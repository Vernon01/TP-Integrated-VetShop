package za.ac.cput.AshDyani.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.AshDyani.domain.Booking;
import za.ac.cput.AshDyani.domain.Doctor;
import za.ac.cput.AshDyani.repository.ServiceRepository;
import za.ac.cput.AshDyani.services.ServicesService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdyani on 2015/05/18.
 */
@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<za.ac.cput.AshDyani.domain.Service> getAllServices()
    {
        List<za.ac.cput.AshDyani.domain.Service> services = new ArrayList<>();
        Iterable<za.ac.cput.AshDyani.domain.Service> values = serviceRepository.findAll();
        for(za.ac.cput.AshDyani.domain.Service value: values)
        {
            services.add(value);
        }

        return services;
    }

    @Override
    public za.ac.cput.AshDyani.domain.Service getService(Integer service_id) {
        return serviceRepository.findOne(service_id);
    }

    @Override
    public Booking getBooking(Integer book_id)
    {
        return serviceRepository.findOne(book_id).getBooking();
    }

    @Override
    public Doctor getDoctor(Integer doc_id) {
        return serviceRepository.findOne(doc_id).getDoctor();
    }
}
