package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealListRequest {

    //0
    @Schema(name = "Test Type ID", example = "1", required = true)
    @JsonProperty("in_test_type_id")
    private Short testTypeId;

    // 1
    @Schema(name = "Start Date",
            example = "2002-07-28",
            required = true,
            description = "Start Date должно быть меньше End Date")
    @JsonProperty("in_start_date")
    private Date startDate;

    // 2
    @Schema(name = "End Date",
            example = "2020-07-28",
            required = true,
            description = "End Date должно быть больше Start Date")
    @JsonProperty("in_end_date")
    private Date endDate;

    // 3
    @Schema(name = "Expert ID",
            example = "1",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_expert_id")
    private Integer expertId;

    // 4
    @Schema(name = "Subject ID",
            example = "1",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_subject_id")
    private Integer subjectId;

    // 5
    @Schema(name = "Language ID",
            example = "1",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_lang_id")
    private Short langId;

    // 6
    @Schema(name = "Appeal Type ID",
            example = "1",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_appeal_type_id")
    private Short appealTypeId;

    // 7
    @Schema(name = "Appeal status type",
            example = "string",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_appeal_status_type_ids")
    private String appealStatusTypeIds;

    // 8
    @Schema(name = "Order List Fields",
            example = "string",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_order_list_fields")
    private String orderListFields;

    // 9
    @Schema(name = "User role Type ID",
            example = "1",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_user_role_type_id")
    private Short userRoleTypeId;

    // 10
    @Schema(name = "Commission Member Type ID",
            example = "1",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_commission_member_type_id")
    private Short commissionMemberTypeId;

    // 11
    @Schema(name = "MID",
            example = "1",
            defaultValue = "null",
            description = "Если поле пустое, то передать - null")
    @JsonProperty("in_mid")
    private Integer mid;

    @JsonProperty("log")
    private WriteLogRequest writeLogRequest;

}
