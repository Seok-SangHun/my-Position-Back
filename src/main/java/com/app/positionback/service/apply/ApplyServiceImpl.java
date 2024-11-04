package com.app.positionback.service.apply;

import com.app.positionback.domain.apply.ApplyListDTO;
import com.app.positionback.repository.apply.ApplyDAO;
import com.app.positionback.utill.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ApplyServiceImpl implements ApplyService{
    private final ApplyDAO applyDAO;

    @Override
    public ApplyListDTO getApplyByCorporationId(int page, Pagination pagination, Long corporationId) {
        ApplyListDTO applyListDTO = new ApplyListDTO();
        pagination.setPage(page);
        pagination.setTotal(applyDAO.getTotal(pagination,corporationId));
        pagination.progress();
        applyListDTO.setPagination(pagination);
        applyListDTO.setApplies(applyDAO.findApplyByCorporationId(pagination,corporationId));

        Pagination ongoingPagination = new Pagination();
        ongoingPagination.setStatus("ongoing");
        int ongoingCount = applyDAO.getTotal(ongoingPagination,corporationId);

        Pagination closedPagination = new Pagination();
        closedPagination.setStatus("closed");
        int closedCount = applyDAO.getTotal(closedPagination,corporationId);

        pagination.setOngoingCount(ongoingCount);
        pagination.setOngoingCount(closedCount);


        return applyListDTO;
    }

    @Override
    public int getTotal(Pagination pagination, Long corporationId) {
        return applyDAO.getTotal(pagination,corporationId);
    }
}
