package za.ac.cput.AshDyani.conf.factory;

import za.ac.cput.AshDyani.domain.Address;

import java.util.Map;

/**
 * Created by ashdyani on 2015/04/26.
 */
public class AddressFactory {

    public static Address createAddress(Map<String, String> values, String code)
    {
        Address address = new Address
                .Builder("7200")
                .street(values.get("street"))
                .town(values.get("town"))
                .build();

                return address;

    }
}
