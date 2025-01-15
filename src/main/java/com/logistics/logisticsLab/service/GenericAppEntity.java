package com.logistics.logisticsLab.service;
import java.util.List;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class GenericAppEntity {
    private static Logger logger = LoggerFactory.getLogger(GenericAppEntity.class);

    @PersistenceContext
    private  EntityManager entityManager;

    public String findFuelId(String val) {
        if (val != null) {
            String fuelDesc = val.toLowerCase().replaceAll("\\s", "");
            try {
                String sql = "Select a.fuel_ID from logisticsLab.Fuel a where REPLACE(lower(a.fuel_desc),' ','') = '" + fuelDesc+ "'";

                Query query = entityManager.createNativeQuery(sql);
                List<String> results = query.getResultList();
                System.out.println(" FUEL ID : "+results);
                return results.get(0);
            }
            catch (Exception e) {
                logger.info("Error in findFuelId" + e.getMessage());
                return "0";
            }
         }
        return "0";


    }

    public double getPetrolPrice(String val) {
       if (val != null) {
            String cityDesc = val.toLowerCase().replaceAll("\\s", "");
            try {
                String sql = "Select a.price from logisticsLab.Petrol_Prices a where REPLACE(lower(a.city),' ','') = '" + cityDesc+ "'";

                Query query = entityManager.createNativeQuery(sql);
                List<Object> results = query.getResultList();
                return Double.valueOf(results.get(0).toString());
            }
            catch (Exception e) {
                logger.info("Error in getPetrolPrice" + e.getMessage());
                return 0.0;
            }
        }
        return 0.0;
    }

    public double getDieselPrice(String val) {
        if (val != null) {
            String cityDesc = val.toLowerCase().replaceAll("\\s", "");
            try {
                String sql = "Select a.price from logisticsLab.Diesel_Prices a where REPLACE(lower(a.city),' ','') = '" + cityDesc+ "'";

                Query query = entityManager.createNativeQuery(sql);
                List<Object> results = query.getResultList();
                return Double.valueOf(results.get(0).toString());
            }
            catch (Exception e) {
                logger.info("Error in getDieselPrice" + e.getMessage());
                return 0.0;
            }
        }
        return 0.0;
    }

    public double getEVPrice(String val) {
        if (val != null) {
            String cityDesc = val.toLowerCase().replaceAll("\\s", "");
            try {
                String sql = "Select a.price from logisticsLab.Electric a where REPLACE(lower(a.city),' ','') = '" + cityDesc+ "'";

                Query query = entityManager.createNativeQuery(sql);
                List<String> results = query.getResultList();
                return Double.parseDouble(results.get(0));
            }
            catch (Exception e) {
                logger.info("Error in getEVPrice" + e.getMessage());
                return 0.0;
            }
        }
        return 0.0;

    }

    public String getRiderFuelType(String val) {

        try {
            String sql = "Select a.fuel_Type from logisticsLab.Rider_Details a where a.Rider_ID = '" + val+ "'";

            Query query = entityManager.createNativeQuery(sql);
            List<String> results = query.getResultList();
            return results.get(0);
        }
        catch (Exception e) {
            logger.info("Error in getMileage" + e.getMessage());
            return "0";
            }
    }


    public String getRiderStatus(String val) {
        if (val != null) {
            String cityDesc = val.toLowerCase().replaceAll("\\s", "");
            try {
                String sql = "Select a.riderStatus from logisticsLab.Rider_Details a where a.Rider_ID = '" + val+ "'";

                Query query = entityManager.createNativeQuery(sql);
                List<String> results = query.getResultList();
                return results.get(0);
            }
            catch (Exception e) {
                logger.info("Error in riderStatus" + e.getMessage());
                return "ID not found";
            }
        }
        return "0";
    }

    public double getMileage(String val) {

      /*  try {
            String sql = "Select a.mileage from logisticsLab.Rider_Details a where a.Rider_ID = '" + val+ "'";

            Query query = entityManager.createNativeQuery(sql);
            List<String> results = query.getResultList();
            return Double.parseDouble(results.get(0));
        }
        catch (Exception e) {
            logger.info("Error in getMileage" + e.getMessage());
            return 0.0;
        }*/
        return 45;
    }

    public double getBalance(String val) {

        try {
            String sql = "Select a.balance from logisticsLab.Rider_Details a where a.Rider_ID = '" + val+ "'";

            Query query = entityManager.createNativeQuery(sql);
            List<String> results = query.getResultList();
            return Double.parseDouble(results.get(0));
        }
        catch (Exception e) {
            logger.info("Error in getCanCoverDistance" + e.getMessage());
            return 0.0;
        }
    }

    public int getTripNum(String val) {

        try {
            String sql = "Select a.trip_Num from logisticsLab.Rider_Details a where a.Rider_ID = '" + val+ "'";

            Query query = entityManager.createNativeQuery(sql);
            List<Object> results = query.getResultList();
            return Integer.parseInt(results.get(0).toString());
        }
        catch (Exception e) {
            logger.info("Error in getTrip_Num" + e.getMessage());
            return 0;
        }
    }

    public List<String> getRiderPool()
    {
        String sql = "Select a.Rider_ID from logisticsLab.Rider_Details a " ;

        Query query = entityManager.createNativeQuery(sql);
        List<String> results = query.getResultList();
        return results;
    }
    public String getLastAddress(String id)
    {
        try {
            String sql = "Select a.lastAddress from logisticsLab.Rider_Details a where a.Rider_ID = '" + id+ "'";

            Query query = entityManager.createNativeQuery(sql);
            List<String> results = query.getResultList();
            return results.get(0);
        }
        catch (Exception e) {
            logger.info("Error in getLastAddress" + e.getMessage());
            return "0";
        }
    }

    public double getKWH(String id)
    {
        try {
            String sql = "Select a.totKWH from logisticsLab.Rider_Details a where a.Rider_ID = '" + id+ "'";

            Query query = entityManager.createNativeQuery(sql);
            List<String> results = query.getResultList();
            return Double.parseDouble(results.get(0));
        }
        catch (Exception e) {
            logger.info("Error in getLastAddress" + e.getMessage());
            return 0.0;
        }
    }

    public Double getDistance(Integer sourceCode, Integer destinationCode) {
        try {

            String sql = "SELECT d.distance FROM logisticsLab.Distance d WHERE d.Source ="+sourceCode+" AND d.Destination = "+destinationCode;

            Query query = entityManager.createNativeQuery(sql);
//            query.setParameter("sourceCode", sourceCode);
//            query.setParameter("destinationCode", destinationCode);

            List<Object> results = query.getResultList();

            // Check if results are empty
            if (results.isEmpty()) {
                logger.warn("No distance found for sourceCode: {} and destinationCode: {}", sourceCode, destinationCode);
                return 0.0;
            }

            // Parse the result to Double
            return Double.valueOf(results.get(0).toString());
//            return 10.0;
        } catch (Exception e) {
            logger.error("Error in getDistance for sourceCode: {} and destinationCode: {} - {}", sourceCode, destinationCode, e.getMessage());
            return 0.0;
        }
    }

}