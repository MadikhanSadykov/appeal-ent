package kz.testcenter.app.appealent.service;

import org.springframework.stereotype.Service;

@Service
public interface CommissionService {

    Short getCommissionMemberTypeIdByUserIdAndTestTypeId(Integer userId, Short testTypeId);

}
