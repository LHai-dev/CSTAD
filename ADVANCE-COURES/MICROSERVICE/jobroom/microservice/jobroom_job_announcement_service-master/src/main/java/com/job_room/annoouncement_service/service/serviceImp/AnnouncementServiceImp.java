package com.job_room.annoouncement_service.service.serviceImp;

import com.job_room.annoouncement_service.components.CommonUtils;
import com.job_room.annoouncement_service.model.announcement.Announcement;
import com.job_room.annoouncement_service.model.announcement.AnnouncementDto;
import com.job_room.annoouncement_service.model.candidate.CandidateEmployee;
import com.job_room.annoouncement_service.model.consume_model.Company;
import com.job_room.annoouncement_service.repository.AnnouncementRepository;
import com.job_room.annoouncement_service.rest.message.BaseApiResponse;
import com.job_room.annoouncement_service.service.AnnouncementService;
import com.job_room.annoouncement_service.utils.PaginationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AnnouncementServiceImp implements AnnouncementService {

    private AnnouncementRepository announcementRepository;

    private ModelMapper modelMapper = new ModelMapper();
    private CommonUtils commonUtils;
    private RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setCommonUtils(CommonUtils commonUtils) {
        this.commonUtils = commonUtils;
    }

    @Autowired
    public void setAnnouncementRepository(AnnouncementRepository announcementRepository) {
        this.announcementRepository= announcementRepository;
    }

    //For admin

    //TODO: Select announcements by company id =========================================================
    @Override
    public Page<AnnouncementDto> selectAnnouncementsByCompany(int companyId,String caption, Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByCompanyIdAndCaptionContainingIgnoreCaseAndStatusIsTrue(companyId,caption,pageable);

        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);
        Page<AnnouncementDto> announcementDtos = paging;
        return announcementDtos;
    }

    //TODO: Ban announcement =========================================================
    @Override
    public AnnouncementDto ban(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);
        if(announcement==null){
            return null;
        }
        announcement.setBanned(true);

        Announcement isUpdated = announcementRepository.save(announcement);

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return announcementDto;
    }

    @Override
    public AnnouncementDto unban(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return  null;

        announcement.setBanned(false);

        Announcement isUpdated = announcementRepository.save(announcement);

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return announcementDto;
    }


    //For Job seeker

    //TODO: Select all announcements by position and range of dates =========================================================
    @Override
    public Page<AnnouncementDto> selectAllByPositionAndDates(String position,Date startDate,Date endDate, Pageable pagination) {

        Page<Announcement> announcements = announcementRepository.findAllByPositionContainingAndClosedDateBetweenAndStatusIsTrueAndIsDraftIsFalseAndIsBannedIsFalse(position,startDate,endDate,pagination);
        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);
        Page<AnnouncementDto> announcementDtos = paging;

        return announcementDtos;
    }

    //For HR

    //TODO: Select announcement by id =========================================================
    @Override
    public AnnouncementDto selectById(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return null;

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        return announcementDto;
    }

    //TODO: Insert announcement =========================================================
    @Override
    public AnnouncementDto insert(AnnouncementDto announcementDto) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date closedDate = formatter.parse(announcementDto.getClosedDate());
        Date publishedDate = formatter.parse(announcementDto.getPublishedDate());

        announcementDto.setStatus(true);
        announcementDto.setUuid(UUID.randomUUID().toString());
        Announcement announcement = modelMapper.map(announcementDto,Announcement.class);
        announcement.setClosedDate(closedDate);
        announcement.setCreatedDate(commonUtils.getCurrentDate());
        announcement.setPublishedDate(publishedDate);
        Announcement isInserted = announcementRepository.save(announcement);

        announcementDto.setId(isInserted.getId());
        announcementDto.setCreatedDate(commonUtils.convertDateToString(isInserted.getCreatedDate()));
        if (isInserted==null) {
            return null;
        }
        else
            return announcementDto;
    }

    //TODO: Delete announcement =========================================================
    @Override
    public AnnouncementDto delete(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return null;

        announcement.setStatus(false);
        announcementRepository.save(announcement);

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        return announcementDto;
    }

    //TODO: Update announcement =========================================================
    @Override
    public AnnouncementDto update(AnnouncementDto announcementDto) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date closedDate = formatter.parse(announcementDto.getClosedDate());
        Date publishedDate = formatter.parse(announcementDto.getPublishedDate());
        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(announcementDto.getId());
        System.out.println(announcement.getCreatedDate());
        if(announcement==null)
            return  null;


        announcement.setPublishedDate(publishedDate);
        announcement.setClosedDate(closedDate);
        announcement.setStatus(true);
        announcement.setImage(announcement.getImage());
        announcement.setForm(announcementDto.getForm());
        announcement.setCompanyId(announcementDto.getCompanyId());
        announcement.setBanned(announcementDto.isBanned());
        announcement.setDraft(announcementDto.isDraft());
        announcement.setCaption(announcementDto.getCaption());
        announcement.setIsShared(announcementDto.getIsShared());
        announcement.setPosition(announcementDto.getPosition());
        announcement.setThumbnail(announcementDto.getThumbnail());

        Announcement isUpdated = announcementRepository.save(announcement);
        System.out.println("Date:"+isUpdated.getCreatedDate());
        if (isUpdated==null) {
            return null;
        }
        else

            announcementDto=modelMapper.map(isUpdated,AnnouncementDto.class);
            announcementDto.setCreatedDate(commonUtils.convertDateToString(isUpdated.getCreatedDate()));
            announcementDto.setClosedDate(commonUtils.convertDateToString(isUpdated.getClosedDate()));
            announcementDto.setPublishedDate(commonUtils.convertDateToString(isUpdated.getPublishedDate()));
            return announcementDto;

    }



    //TODO: Share announcement =========================================================
    @Override
    public AnnouncementDto share(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return  null;

        announcement.setIsShared(true);

        Announcement isUpdated = announcementRepository.save(announcement);

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return announcementDto;
    }

    @Override
    public AnnouncementDto unshare(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return  null;

        announcement.setIsShared(false);

        Announcement isUpdated = announcementRepository.save(announcement);

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return announcementDto;
    }

    @Override
    public AnnouncementDto draft(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return  null;

        announcement.setDraft(true);

        Announcement isUpdated = announcementRepository.save(announcement);

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return announcementDto;
    }

    @Override
    public AnnouncementDto undraft(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return  null;

        announcement.setDraft(false);

        Announcement isUpdated = announcementRepository.save(announcement);

        AnnouncementDto announcementDto = modelMapper.map(announcement,AnnouncementDto.class);

        if (isUpdated==null) {
            return null;
        }
        else
            return announcementDto;
    }

    @Override
    public Page<AnnouncementDto> findAllByCompanyIdAndClosedDate(int id,String caption, Date currentDate,Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByCompanyIdAndCaptionContainingIgnoreCaseAndClosedDateIsLessThanEqualAndStatusIsTrue(id,caption,currentDate,pageable);

        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);
        Page<AnnouncementDto> announcementDtos = paging;

        return announcementDtos;
    }
    // TODO select All position for filter by position
    @Override
    public List<String> selectAllPosition(int id) {
        List<String> listPosition=announcementRepository.selectAllPosition(id);
        return listPosition;
    }

    @Override
    public Page<AnnouncementDto> selectDraft(int id,String caption,Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByCompanyIdAndCaptionContainingIgnoreCaseAndStatusIsTrueAndIsDraftIsTrueAndIsBannedIsFalse(id,caption,pageable);
        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);
        Page<AnnouncementDto> announcementDtos = paging;
        return announcementDtos;
    }

    ///TODO: Select announcement by id =========================================================
    @Override
    public Page<AnnouncementDto> selectDraftByCompanyAndPosition(int id, String position, Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByCompanyIdAndPositionEqualsAndStatusIsTrueAndIsDraftIsTrueAndIsBannedIsFalse(id,position,pageable);
        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);
        Page<AnnouncementDto> announcementDtos = paging;
        return announcementDtos;
    }

    //TODO select all position
    @Override
    public Page<AnnouncementDto> findAllByPosition(String position, Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByPositionContainingAndStatusIsTrueAndIsDraftIsFalseAndIsBannedIsFalse(position,pageable);
        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);
        Page<AnnouncementDto> announcementDtos = paging;
        return announcementDtos;
    }


    //TODO filter Announcement By Company and Position

    @Override
    public Page<AnnouncementDto> filterActiveAnnouncementByCompanyIdAndPosition(int id, String position,Date currentDate,Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByCompanyIdAndPositionEqualsAndClosedDateGreaterThanAndStatusIsTrue(id,position,currentDate,pageable);

        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);

        Page<AnnouncementDto> announcementDtos = paging;
        return announcementDtos;
    }

    ///TODO select Active Announcement
    @Override
    public Page<AnnouncementDto> selectActiveAnnouncementByCompanyId(int id, String caption, Date currentDate, Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByCompanyIdAndCaptionContainingIgnoreCaseAndClosedDateGreaterThanAndStatusIsTrue(id,caption,currentDate,pageable);

        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);

        Page<AnnouncementDto> announcementDtos = paging;
        return paging;
    }

    //TODO filter close announcement by company and position
    @Override
    public Page<AnnouncementDto> filterCloseAnnouncementByCompanyIdAndPosition(int id, String position, Date currentDate, Pageable pageable) {

        Page<Announcement> announcements = announcementRepository.findAllByCompanyIdAndPositionEqualsAndClosedDateIsLessThanEqualAndStatusIsTrue(id,position,currentDate,pageable);

        PaginationUtils<AnnouncementDto, Page<Announcement>> paging = new PaginationUtils<>(AnnouncementDto.class);
        paging.setData(announcements);

        Page<AnnouncementDto> announcementDtos = paging;
        return announcementDtos;
    }

    @Override
    public AnnouncementDto findById(int id) {

        Announcement announcement = announcementRepository.findByIdAndStatusIsTrue(id);

        if(announcement==null)
            return null;

        AnnouncementDto announcementDto =modelMapper.map(announcement,AnnouncementDto.class);

        return announcementDto;
    }

    //TODO consume Company
    @Override
    public Company companyById(int id) {
        ParameterizedTypeReference<BaseApiResponse<Company>> parameterizedTypeReference =
                new ParameterizedTypeReference<BaseApiResponse<Company>>() {
                };

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<BaseApiResponse<Company>> result = restTemplate.exchange("http://35.197.132.204:30005/api/v1/companies/" + id, HttpMethod.GET, entity, parameterizedTypeReference);
        if (result.getBody().getData() != null) {
            return result.getBody().getData();
        } else {
            return null;
        }

    }
}
