package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Address;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepo addressRepo;

    public String addAddress(Address address) {
        if(address!=null){
            addressRepo.save(address);
            return "Address added successfully";
        }
        return "Address not added successfully";

    }

    public List<Address> getAllAddress(Long addressId) {
        if(addressId==null){
            return addressRepo.findAll();
        }else{
            List<Address> addressList = new ArrayList<>();
            addressList.add(addressRepo.findById(addressId).get());
            return addressList;
        }
    }

    public String deleteAddressById(Long addressId) {
        Optional<Address> optionalAddress = addressRepo.findById(addressId);
        if(optionalAddress.isEmpty()){
            return "Address with id "+addressId + " is not present";
        }else{
            addressRepo.deleteById(addressId);
            return "Address with id "+addressId + " deleted successfully";
        }
    }

    public String updateAddress(Long addressId, Address address) {
        Optional<Address> optionalAddress = addressRepo.findById(addressId);
        if(optionalAddress.isEmpty()){
            return "Address with id "+addressId + " is not present";
        }else{
            address.setAddressId(addressId);
            addressRepo.save(address);
            return "Address with id "+addressId + " updated successfully";
        }
    }
}
