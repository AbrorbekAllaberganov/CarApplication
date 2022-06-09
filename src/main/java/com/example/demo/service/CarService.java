package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.payload.CarPayload;
import com.example.demo.payload.Result;
import com.example.demo.repository.AttachmentRepository;
import com.example.demo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final AttachmentRepository attachmentRepository;
    private final Result result;

    public Result saveCar(CarPayload carPayload){
        try {
            Car car=new Car();
            car.setName(carPayload.getName());
            car.setDescription(carPayload.getDescription());
            car.setPrice(carPayload.getPrice());
            car.setAttachment(attachmentRepository.findByHashId(carPayload.getImageHashId()));
            return result.success(carRepository.save(car));
        }catch (Exception e){
            return result.exception(e);
        }
    }

    public Result editCar(Long id,CarPayload carPayload){
        try {
            Car car=getCar(id);
            car.setName(carPayload.getName());
            car.setDescription(carPayload.getDescription());
            car.setPrice(carPayload.getPrice());
            car.setAttachment(attachmentRepository.findByHashId(carPayload.getImageHashId()));
            return result.success(carRepository.save(car));
        }catch (Exception e){
            return result.exception(e);
        }
    }

    public Result getAll(){
        return result.success(carRepository.findAll());
    }
    public Result findById(Long id){
        return result.success(getCar(id));
    }

    public Result deleteCar(Long id){
        try {
            carRepository.deleteById(id);
            return result.delete();
        }catch (Exception e){
            return result.exception(e);
        }
    }

    public Car getCar(Long id){
        return carRepository.findById(id).orElse(new Car());
    }
}
