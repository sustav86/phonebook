package org.sustav.springmvc.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sustav.springmvc.dto.HumanDto;
import org.sustav.springmvc.entity.Human;
import org.sustav.springmvc.entity.Phone;
import org.sustav.springmvc.repository.PhoneBookRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anton Sustavov
 * @since 2020/02/12
 */
@Service
public class PhoneBookServiceImpl implements PhoneBookService {
    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Override
    public long create(HumanDto humanDto) {
        ModelMapper modelMapper = new ModelMapper();
        Human newHuman = modelMapper.map(humanDto, Human.class);
        for (Phone phone :
                newHuman.getPhone()) {
            phone.setHuman(newHuman);
            phone.getPhoneCompany().setPhone(phone);
        }
        return phoneBookRepository.save(newHuman).getId();
    }

    @Override
    public List<HumanDto> showAll() {
        List<Human> humans = phoneBookRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<HumanDto> collect = humans.stream()
                .map(entity -> modelMapper.map(entity, HumanDto.class))
                .collect(Collectors.toList());
        return collect;
    }
}
