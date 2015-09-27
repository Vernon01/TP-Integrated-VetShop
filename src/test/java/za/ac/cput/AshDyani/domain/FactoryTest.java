package za.ac.cput.AshDyani.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.AshDyani.conf.factory.*;

import java.util.*;

/**
 * Created by ashdyani on 2015/04/25.
 */
public class FactoryTest {


    Employee employee;
    Customer customer;
    Doctor doctor;
    Pet pet;
    Address address;
    Date book_date;
    Date prescrip_date;
    Date inv_date;
    Prescription prescription;
    Medication medication;
    Service service;
    Integer pl_id;

    @Before
    public void setUp() throws Exception {

        book_date = new Date(2015, 04, 15);
        prescrip_date = new Date(2015, 03, 01);
        inv_date = new Date(2015, 04, 02);
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testCreateAddress() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("street","Jikeleza");
        values.put("town", "Hermanus");

        address = AddressFactory.createAddress(values, "7200");

        Assert.assertEquals("Jikeleza", address.getStreet());

    }

    @Test
    public void testUpdateAddress() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("street","Jikeleza");
        values.put("town", "Hermanus");

       address = AddressFactory.createAddress(values, "7200");

        Address newaddress = new Address
                .Builder("7200")
                .copy(address)
                .town("Hermanus")
                .street("Jikeleza")
                .build();

        Assert.assertEquals("Jikeleza",newaddress.getStreet());

    }

    @Test
    public void testCreateCustomer() throws Exception {

        List<Pet> pets = new ArrayList<Pet>();
        //Pet pet2 = new Pet();

        Pet pet = PetFactory
                .createPet("Spotty", "Dog");

        pets.add(pet);

        Customer customer = CustomerFactory.createCustomer("Asiphe", "Dyani", address, pets);

        Assert.assertEquals("Asiphe", customer.getCust_name());

    }

    @Test
    public void testUpdateCustomer() throws Exception
    {
        List<Pet> pets = new ArrayList<Pet>();

        Customer customer = CustomerFactory.createCustomer("Asiphe", "Dyani", address, pets);

        Customer newCustomer = new Customer
                .Builder(customer.getCust_name(), customer.getCust_lname())
                .copy(customer)
                .pets(pets)
                .address(address)
                .build();
        Assert.assertEquals("Asiphe", newCustomer.getCust_name());


    }

    @Test
    public void testCreateEmployee() throws Exception
    {
        Employee employee = EmployeeFactory.createEmployee("Nurse", "Bettina", address);

        Assert.assertEquals("Bettina", employee.getEmp_name());
    }

    @Test
    public void testUpdateEmployee() throws Exception
    {
        Employee employee = EmployeeFactory.createEmployee("Nurse", "Bettina", address);

        Employee newemployee = new Employee
                .Builder(employee.getEmp_type(), employee.getEmp_name())
                .copy(employee)
                .address(address)
                .build();

        Assert.assertEquals("Nurse", newemployee.getEmp_type());

    }

    @Test
    public void testCreateDoctor() throws Exception
    {
        Doctor doctor = DoctorFactory.createDoctor("Dr Sheldon", address);

        Assert.assertEquals("Dr Sheldon", doctor.getDoc_name());
    }

    @Test
    public void testUpdateDoctor() throws Exception
    {
        Doctor doctor = DoctorFactory.createDoctor("Dr Sheldon", address);

        Doctor newdoctor = new Doctor
                .Builder(doctor.getDoc_name())
                .copy(doctor)
                .address(address)
                .build();

        Assert.assertEquals("Dr Sheldon", newdoctor.getDoc_name());

    }

    @Test
    public void testCreatePet() throws Exception
    {
        Pet pet = PetFactory.createPet("Spotty", "Dog");

        Assert.assertEquals("Spotty", pet.getPet_name());
    }

    @Test
    public void testUpdatePet() throws Exception
    {
        Pet pet = PetFactory.createPet("Spotty", "Dog");

        Pet newpet = new Pet
                .Builder(pet.getPet_name())
                .copy(pet)
                .petSpecies(pet.getPet_species())
                .build();

        Assert.assertEquals("Spotty", newpet.getPet_name());
    }

    @Test
    public void testCreateBooking () throws Exception
    {
        Booking booking = BookingFactory.createBooking(book_date, customer, employee);

        Assert.assertEquals(book_date, booking.getBook_date());
    }

    @Test
    public void testUpdateBooking() throws Exception {
        Booking booking = BookingFactory.createBooking(book_date, customer, employee);

        Booking newbooking = new Booking
                .Builder(book_date)
                .copy(booking)
                .customer(customer)
                .employee(employee)
                .build();
        Assert.assertEquals(book_date, newbooking.getBook_date());

    }

    @Test
    public void testCreateMedication() throws Exception
    {
        Medication medication = MedicationFactory.createMedication("Tablet", "Grandpa");

        Assert.assertEquals("Grandpa", medication.getMed_name());
    }

    @Test
    public void testUpdateMedication() throws Exception
    {
        Medication medication = MedicationFactory.createMedication("Tablet", "Grandpa");

        Medication newmedication = new Medication
                .Builder(medication.getMed_type(), medication.getMed_name() )
                .copy(medication)
                .build();

        Assert.assertEquals("Grandpa", newmedication.getMed_name());
    }

    @Test
    public void testCreatePrescription() throws Exception
    {
        Prescription prescription = PrescriptionFactory.createPrescription(doctor, pet, prescrip_date);

        Assert.assertEquals(prescrip_date, prescription.getPrescrip_date());
    }

    @Test
    public void testUpdatePrescription() throws Exception {
        Prescription prescription = PrescriptionFactory.createPrescription(doctor, pet, prescrip_date);

        Prescription newprescription = new Prescription
                .Builder(doctor, pet)
                .copy(prescription)
                .prescripDate(prescrip_date)
                .build();

        Assert.assertEquals(prescrip_date, prescription.getPrescrip_date());

    }

    @Test
    public void testCreatePrescriptionLine() throws Exception
    {
        Prescription_Line prescription_line = Prescription_LineFactory.createPrescription(prescription, medication);

        Assert.assertEquals(prescription, prescription_line.getPrescription());
    }

    @Test
    public void testUpdatePrescriptionLine() throws Exception
    {

        Prescription_Line prescription_line = Prescription_LineFactory.createPrescription(prescription, medication);

        Prescription_Line newprescription_line = new Prescription_Line
                .Builder(prescription, medication)
                .copy(prescription_line)
                .build();

        Assert.assertEquals(prescription, newprescription_line.getPrescription());
    }


    @Test
    public void testCreateInvoice() throws Exception
    {
        Invoice invoice = InvoiceFactory.createInvoice(service, inv_date);

        Assert.assertEquals(inv_date, invoice.getInv_date());
    }

    @Test
    public void testUpdateInvoice() throws Exception
    {
        Invoice invoice = InvoiceFactory.createInvoice(service, inv_date);

        Invoice newInvoice = new Invoice
                .Builder(service)
                .copy(invoice)
                .invoiceDate(inv_date)
                .build();

        Assert.assertEquals(inv_date, newInvoice.getInv_date());
    }
}

