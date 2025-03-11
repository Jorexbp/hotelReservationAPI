package com.hotelReservationAPI.hotelReservationAPI.service;

import com.hotelReservationAPI.hotelReservationAPI.dto.HotelRoomTO;
import com.hotelReservationAPI.hotelReservationAPI.dto.ReservationTO;
import com.hotelReservationAPI.hotelReservationAPI.exceptionHandler.exceptions.ConflictException;
import com.hotelReservationAPI.hotelReservationAPI.mapper.HotelRoomMapper;
import com.hotelReservationAPI.hotelReservationAPI.mapper.ReservationMapper;
import com.hotelReservationAPI.hotelReservationAPI.model.HotelRoomEntity;
import com.hotelReservationAPI.hotelReservationAPI.model.ReservationEntity;
import com.hotelReservationAPI.hotelReservationAPI.repository.HotelRoomRepository;
import com.hotelReservationAPI.hotelReservationAPI.repository.ReservationRepository;
import com.hotelReservationAPI.hotelReservationAPI.service.use_cases.ReservationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReservationService implements ReservationUseCase {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Autowired
    private HotelRoomMapper hotelRoomMapper;

    @Autowired
    private HotelRoomService hotelRoomService;

    @Override
    public ReservationTO getReservationById(Long id) {
        Optional<ReservationEntity> reservationEntityOptional = reservationRepository.findById(id);

        if(reservationEntityOptional.isEmpty()){
            return reservationMapper.toDto(reservationEntityOptional.get());
        }

        return null;
    }

    @Override
    public ReservationTO createReservation(ReservationTO reservationTO) {
        // Recoger id de la Room y buscar la room por id
        Optional<HotelRoomEntity> hotelRoomEntity = hotelRoomRepository.findById(reservationTO.getRoomId());

        // Validar que existe la room
        if(hotelRoomEntity.isEmpty())
            return null;

        HotelRoomTO hotelRoomTO = hotelRoomMapper.toDto(hotelRoomEntity.get());
        // Validar que esta disponible
        if(!hotelRoomTO.getAvailable())
            throw new ConflictException("La sala seleccionada, no está disponible");

        if (checkDates(reservationTO)) throw new ConflictException("Las fechas de reserva son incoherentes");

        ReservationEntity reservation = reservationRepository.save(reservationMapper.toEntity(reservationTO));

        hotelRoomTO.setAvailable(false);
        hotelRoomService.updateRoom(reservationTO.getRoomId() ,hotelRoomTO);

        return reservationMapper.toDto(reservation);
    }

    private static boolean checkDates(ReservationTO reservationTO) {
        // Comprobar que mi CheckInDate es ahora o posterior
        if(!(reservationTO.getCheckInDate().isEqual(LocalDateTime.now()) || reservationTO.getCheckInDate().isAfter(LocalDateTime.now())))
            return true;

        // Comprobar que mi CheckOutDate es posterior a CheckInDate
        if(reservationTO.getCheckOutDate().isBefore(reservationTO.getCheckInDate()))
            return true;

        return false;
    }

    @Override
    public Boolean deleteReservation(Long id) {
        Optional<ReservationEntity> reservationEntityOpional = reservationRepository.findById(id);

        if(reservationEntityOpional.isEmpty())
            throw new ConflictException(String.format("La reserva con el id '%s' no existe",id));

        ReservationTO reservation = reservationMapper.toDto(reservationEntityOpional.get());

        Optional<HotelRoomEntity> hotelRoomEntity = hotelRoomRepository.findById(reservation.getRoomId());
        if(hotelRoomEntity.isEmpty())
            throw new ConflictException(String.format("La habitación con el id '%s' no existe",id));

        HotelRoomTO hotelRoomTO = hotelRoomMapper.toDto(hotelRoomEntity.get());
        hotelRoomTO.setAvailable(true);

        hotelRoomService.updateRoom(reservation.getRoomId(), hotelRoomTO);

        reservationRepository.deleteById(id);
        return true;
    }
}