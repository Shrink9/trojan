package work.shrink.portupdater2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import work.shrink.portupdater2.entity.Domain;
import work.shrink.portupdater2.service.DomainService;
import work.shrink.portupdater2.mapper.DomainMapper;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceImpl extends ServiceImpl<DomainMapper,Domain> implements DomainService{
}




