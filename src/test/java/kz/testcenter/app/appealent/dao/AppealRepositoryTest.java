package kz.testcenter.app.appealent.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class AppealRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Test
    public void test_call_getAppealList() {
        LocalDate startLocalDate = LocalDate.of(2014, 9, 11);
        Date startDate = Date.valueOf(startLocalDate);

        LocalDate endLocalDate = LocalDate.of(2023, 9, 11);
        Date endDate = Date.valueOf(endLocalDate);

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("public.fn_get_appeal_list")
                .registerStoredProcedureParameter("in_test_type_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_start_date", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_end_date", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_expert_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_subject_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_lang_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_appeal_type_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_appeal_status_type_ids", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_order_list_fields", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_user_role_type_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_commission_member_type_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("in_mid", Integer.class, ParameterMode.IN)

                .setParameter("in_test_type_id", (short) 2)
                .setParameter("in_start_date", startDate)
                .setParameter("in_end_date", endDate)
                .setParameter("in_expert_id", 0)
                .setParameter("in_subject_id", 0)
                .setParameter("in_lang_id", (short) 0)
                .setParameter("in_appeal_type_id", (short) 0)
                .setParameter("in_appeal_status_type_ids", "")
                .setParameter("in_order_list_fields", "")
                .setParameter("in_user_role_type_id", (short) 0)
                .setParameter("in_commission_member_type_id", (short) 0)
                .setParameter("in_mid", 0);

        query.execute();
        List<Object[]> dataList = query.getResultList();
        System.out.println(dataList.get(0)[3]);
        for (Object[] objArray : dataList) {
            for (int i = 0; i < objArray.length; i++) {
                System.out.println(i + ") " + objArray[i]);
            }

        }

    }

}
