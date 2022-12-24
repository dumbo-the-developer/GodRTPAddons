package me.adarsh.GodRTPAddons.addons.portals;

import me.adarsh.GodRTPAddons.util.LocSerialization;
import me.adarsh.GodRTPAddons.addons.portals.region.PortalsRegionInfo;
import me.adarsh.GodRTPAddons.database.Database;
import me.adarsh.GodRTPAddons.database.DatabaseColumn;
import me.adarsh.GodRTPAddons.database.Errors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PortalsDatabase extends Database {

    enum Columns implements DatabaseColumn {
        LOCATION_1("location_1", "longtext"),
        LOCATION_2("location_2", "longtext"),
        NAME("name", "varchar(255)"),
        WORLD("world", "text");

        private final String name;
        private final String type;

        Columns(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getType() {
            return type;
        }
    }

    public PortalsDatabase(){
        super("addon_portals");
    }

    private final String createTable = "CREATE TABLE IF NOT EXISTS " + table + " (" +
            "`" + Columns.NAME.name + "` " + Columns.NAME.type + " PRIMARY KEY," +
            "`" + Columns.LOCATION_1.name + "` " + Columns.LOCATION_2.type + "," +
            "`" + Columns.LOCATION_2.name + "` " + Columns.LOCATION_2.type + "," +
            "`" + Columns.WORLD.name + "` " + Columns.WORLD.type +
            ");";


    @Override
    public String getTableFormat() {
        return createTable;
    }

    @Override
    public void load(DatabaseColumn[] columns) {
        super.load(columns);
    }

    public List<PortalsRegionInfo> getPortals() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getSQLConnection();
            ps = conn.prepareStatement("SELECT * FROM " + table);
            rs = ps.executeQuery();
            List<PortalsRegionInfo> list = new ArrayList<>();
            while (rs.next()) {
               PortalsRegionInfo info = new PortalsRegionInfo();
               info.setLoc1(LocSerialization.getLocationFromString(rs.getString(Columns.LOCATION_1.name)));
               info.setLoc2(LocSerialization.getLocationFromString(rs.getString(Columns.LOCATION_2.name)));
               info.setName(rs.getString(Columns.NAME.name));
               info.setWorld(rs.getString(Columns.WORLD.name));
               list.add(info);
            }
            return list;
        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionExecute(), ex);
        } finally {
            close(ps, rs, conn);
        }
        return null;
    }

    public boolean removePortal(PortalsRegionInfo portal) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean success = true;
        try {
            conn = getSQLConnection();
            ps = conn.prepareStatement("DELETE FROM " + table +
                    " WHERE " + Columns.NAME.name + " = ?");
            ps.setString(1, portal.getName());
            ps.executeUpdate();
        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionExecute(), ex);
            success = false;
        } finally {
            close(ps, null, conn);
        }
        return success;
    }

    public boolean setPortal(PortalsRegionInfo portal) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean success = true;
        try {
            conn = getSQLConnection();
            ps = conn.prepareStatement("INSERT INTO " + table + "(" +
                    Columns.NAME.name + ", " +
                    Columns.LOCATION_1.name + ", " +
                    Columns.LOCATION_2.name + ", " +
                    Columns.WORLD.name + ") VALUES (?, ?, ?, ?) "
                    + "ON CONFLICT(" + Columns.NAME.name + ") DO UPDATE SET " +
                    Columns.LOCATION_1.name + " = ?, " + Columns.LOCATION_2.name + " = ?, " + Columns.WORLD.name + " = ?");
            ps.setString(1, portal.getName());
            String serialLocation_1 = LocSerialization.getStringFromLocation(portal.getLoc1());
            String serialLocation_2 = LocSerialization.getStringFromLocation(portal.getLoc2());
            ps.setString(2, serialLocation_1);
            ps.setString(3, serialLocation_2);
            ps.setString(4, portal.getWorld());
            ps.setString(5, serialLocation_1);
            ps.setString(6, serialLocation_2);
            ps.setString(7, portal.getWorld());
            ps.executeUpdate();
        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionExecute(), ex);
            success = false;
        } finally {
            close(ps, null, conn);
        }
        return success;
    }
}
