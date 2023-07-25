package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.CommissionDAO;
import kz.testcenter.app.appealent.service.CommissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommissionServiceImpl implements CommissionService {

    private final CommissionDAO commissionDAO;

    @Override
    public Short getCommissionMemberTypeIdByUserIdAndTestTypeId(Integer userId, Short testTypeId) {
        return commissionDAO.getCommissionMemberTypeIdByUserId(userId, testTypeId);
    }

}
