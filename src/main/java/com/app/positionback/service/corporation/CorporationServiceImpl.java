package com.app.positionback.service.corporation;

import com.app.positionback.domain.corporation.CorporationVO;
import com.app.positionback.domain.file.FileDTO;
import com.app.positionback.domain.member.MemberDTO;
import com.app.positionback.repository.corporation.CorporationDAO;
import com.app.positionback.repository.file.CorporationFileDAO;
import com.app.positionback.repository.file.FileDAO;
import com.app.positionback.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CorporationServiceImpl implements CorporationService {
    private final CorporationDAO corporationDAO;
    private final CorporationFileDAO corporationFileDAO;
    private final FileDAO fileDAO;

    @Override
    public void join(CorporationVO corporationVO) {
        corporationDAO.save(corporationVO);
    }

    @Override
    public Long getLastInsertId() {
        return corporationDAO.findLastInsertId();
    }

    @Override
    public int checkCorporationEmail(String corporationEmail) {
        return corporationDAO.findCountByCorporationEmail(corporationEmail);
    }

    @Override
    public Optional<CorporationVO> login(MemberDTO memberDTO) {
        return corporationDAO.findByCorporationEmailAndCorporationPassword(memberDTO);
    }

    @Override
    public FileDTO getCorporationFileById(Long corporationId) {
        Long fileId = corporationFileDAO.getFileIdByCorporationId(corporationId);
        return fileDAO.findById(fileId);
    }
}
