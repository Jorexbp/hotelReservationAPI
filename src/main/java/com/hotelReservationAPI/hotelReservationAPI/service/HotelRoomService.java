package com.hotelReservationAPI.hotelReservationAPI.service;

import com.hotelReservationAPI.hotelReservationAPI.dto.HotelRoomTO;
import com.hotelReservationAPI.hotelReservationAPI.exceptionHandler.exceptions.ConflictException;
import com.hotelReservationAPI.hotelReservationAPI.mapper.HotelRoomMapper;
import com.hotelReservationAPI.hotelReservationAPI.model.HotelRoomEntity;
import com.hotelReservationAPI.hotelReservationAPI.repository.HotelRoomRepository;
import com.hotelReservationAPI.hotelReservationAPI.service.use_cases.HotelRoomUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelRoomService implements HotelRoomUseCase {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Autowired
    private HotelRoomMapper hotelRoomMapper;

    @Override
    public List<HotelRoomTO> getAvailableRooms() {
        return hotelRoomRepository.findAvailable().stream()
                        .map(hotelRoomMapper::toDto)
                        .toList();
    }

    @Override
    public HotelRoomTO getRoomDetails(Long id) {
        Optional<HotelRoomEntity> hotelRoom = hotelRoomRepository.findById(id);

        if(hotelRoom.isEmpty())
           throw new ConflictException(String.format("La habitación con el id %s no existe",id));

        return hotelRoomMapper.toDto(hotelRoom.get());
    }

    @Override
    public HotelRoomTO createRoom(HotelRoomTO hotelRoomTO) {
      HotelRoomEntity hotelRoomEntity = hotelRoomRepository.save(hotelRoomMapper.toEntity(hotelRoomTO));
      return hotelRoomMapper.toDto(hotelRoomEntity);
    }

    @Override
    public HotelRoomTO updateRoom(Long id, HotelRoomTO hotelRoomTO) {
        Optional<HotelRoomEntity> hotelRoomEntity = hotelRoomRepository.findById(id);

        if(hotelRoomEntity.isEmpty())
            throw new RuntimeException("Habitación no encontrada");

        HotelRoomEntity entity =  hotelRoomRepository.save(hotelRoomMapper.toEntity(hotelRoomTO));
        return hotelRoomMapper.toDto(entity);
    }

    @Override
    public Boolean deleteRoom(Long id) {

        Optional<HotelRoomEntity> hotelRoomEntity = hotelRoomRepository.findById(id);

        if(hotelRoomEntity.isEmpty())
            throw new RuntimeException("Habitación no encontrada");

        HotelRoomTO hotelRoomTO = hotelRoomMapper.toDto(hotelRoomEntity.get());

        if(hotelRoomTO.getAvailable()){
            hotelRoomRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
