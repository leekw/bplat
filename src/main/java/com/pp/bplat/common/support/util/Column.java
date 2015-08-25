package com.pp.bplat.common.support.util;



public abstract class Column {
	
	public enum Name {
		JOBTYPE("JOBTYPE")
		, EAI_SEQ("EAI_SEQ")
		, EAI_STTUS_CD("EAI_STTUS_CD")
		, EAI_TRT_DIV_CD("EAI_TRT_DIV_CD")
		, BASE_YM("BASE_YM")
		, ORG_ID("ORG_ID")
		, LOB_ID("LOB_ID")
		, LOB_NM("LOB_NM")
		, SBSC_TYPE_CD("SBSC_TYPE_CD")
		, AGNCY_ACRU_CASCNT("AGNCY_ACRU_CASCNT")
		, TRT_DATE("TRT_DATE")
		, WRKJOB_TRTR_ID("WRKJOB_TRTR_ID")
		, ACRU_DIV_CD("ACRU_DIV_CD")
		, TRT_CASCNT("TRT_CASCNT")
		, TRT_USER_ID("TRT_USER_ID")
		, SYS_RECD_CRET_DT("SYS_RECD_CRET_DT")
		
		, BASE_DATE("BASE_DATE")
		, ACRU_AGNCY_ID("ACRU_AGNCY_ID")
		, ACCUM_NEW_SBSCR_CASCNT("ACCUM_NEW_SBSCR_CASCNT")
		, ACCUM_TRMN_SBSCR_CASCNT("ACCUM_TRMN_SBSCR_CASCNT")
		, ACCUM_AGNCY_CHG_INC_CASCNT("ACCUM_AGNCY_CHG_INC_CASCNT")
		, ACCUM_AGNCY_CHG_DCRS_CASCNT("ACCUM_AGNCY_CHG_DCRS_CASCNT")
		, ACCUM_OPN_CNCL_SBSCR_CASCNT("ACCUM_OPN_CNCL_SBSCR_CASCNT")
		, ACCUM_ICG_SBSCR_CASCNT("ACCUM_ICG_SBSCR_CASCNT")
		, ACCUM_ICG_CNCL_SBSCR_CASCNT("ACCUM_ICG_CNCL_SBSCR_CASCNT")
		, TDAY_NEW_CASCNT("TDAY_NEW_CASCNT")
		, TDAY_TRMN_CASCNT("TDAY_TRMN_CASCNT")
		, TDAY_AGNCY_CHG_INC_CASCNT("TDAY_AGNCY_CHG_INC_CASCNT")
		, TDAY_AGNCY_CHG_DCRS_CASCNT("TDAY_AGNCY_CHG_DCRS_CASCNT")
		, TDOP_CNCL_SBSCR_CASCNT("TDOP_CNCL_SBSCR_CASCNT")
		, TDAY_ICG_SBSCR_CASCNT("TDAY_ICG_SBSCR_CASCNT")
		, TDAY_ICG_CNCL_SBSCR_CASCNT("TDAY_ICG_CNCL_SBSCR_CASCNT")
		
		, ORG_NM("ORG_NM")
		, OCC_SUM_PRVD_CASCNT("OCC_SUM_PRVD_CASCNT")
		
		, FEE_ACRU_YM("FEE_ACRU_YM")
		, SETL_YM("SETL_YM")
		, TGT_ORG_ID("TGT_ORG_ID")
		, FEE_CD("FEE_CD")
		, ORIGIN_SETL_ACC_ID("ORIGIN_SETL_ACC_ID")
		, PROD_SVC_ID("PROD_SVC_ID")
		, PROD_NM("PROD_NM")
		, FEE_BASIS_CASCNT("FEE_BASIS_CASCNT")
		, TOTALCNT("TOTALCNT")
		, FEE_BASIS_AMT("FEE_BASIS_AMT")
		, TOTALAMOUNT("TOTALAMOUNT")
		
		, SVC_CONT_NO("SVC_CONT_NO")
		, FEE_DCID_AMT("FEE_DCID_AMT")
		
		, ACCUM_YM("ACCUM_YM")
		, SETL_ACC_ID("SETL_ACC_ID")
		, ACCUM_GUIDE_DATA_VAL("ACCUM_GUIDE_DATA_VAL")
		, ACCUM_GUIDE_DATA_AMT("ACCUM_GUIDE_DATA_AMT")
		
		, SETL_ID("SETL_ID")
		, FEE_STTUS_CD("FEE_STTUS_CD")
		, GUIDE_DATA_ID("GUIDE_DATA_ID")
		, PTNR_PLCY_ID("PTNR_PLCY_ID")
		, PLCY_UNIT_ID("PLCY_UNIT_ID")
		, SETL_ACCUM_ID("SETL_ACCUM_ID")
		, SETL_TYPE_ID("SETL_TYPE_ID")
		, FEE_TOT_AMT("FEE_TOT_AMT")
		, APD_FEE_TOT_AMT("APD_FEE_TOT_AMT")
		, LOW_ORG_ID("LOW_ORG_ID")

		, GUIDE_DATA_DTL_ID("GUIDE_DATA_DTL_ID")
		, FACTR_ID("FACTR_ID")
		, FACTR_NM("FACTR_NM")
		, FACTR_VAL("FACTR_VAL")
		, FACTR_VAL_SBST("FACTR_VAL_SBST")
		, EV_DT("EV_DT")
		, CHG_WHY_VAL("CHG_WHY_VAL")
		
		, TRC_ORG_ID("TRC_ORG_ID")
		, OCC_ORG_ID("OCC_ORG_ID")
		, APLY_FNS_YM("APLY_FNS_YM")
		, SETL_TRC_EXP_YM("SETL_TRC_EXP_YM")
		, APLY_ST_YM("APLY_ST_YM")
		, SETL_TRC_EFCT_YM("SETL_TRC_EFCT_YM")
		, TKO_ORG_ID("TKO_ORG_ID")
		
		, TRC_DIV_CD("TRC_DIV_CD")
		, TRC_CD("TRC_CD")
		
		, SBSD_PRVD_DT("SBSD_PRVD_DT")
		, SBSD_SUCC_AMT("SBSD_SUCC_AMT")
		, HNDSET_INSL_AMT("HNDSET_INSL_AMT")
		, USIM_INSL_AMT("USIM_INSL_AMT")
		, BOND_SUCC_AMT("BOND_SUCC_AMT")
		
		, WORK_TYPE_CD("WORK_TYPE_CD")
		, BASE_LO_ID("BASE_LO_ID")
		, ADMNS_ZONE_NM("ADMNS_ZONE_NM")
		, ADMNS_ZONE_TYPE_CD("ADMNS_ZONE_TYPE_CD")
		, LEGDONG_ADMDONG_DIV_CD("LEGDONG_ADMDONG_DIV_CD")
		, ADMDONG_LEGDONG_ID("ADMDONG_LEGDONG_ID")
		, CHG_DT("CHG_DT")
		, ADR_CHG_DESC_SBST("ADR_CHG_DESC_SBST")
		, LI_NM("LI_NM")
		, UP_LO_ID("UP_LO_ID")
		, DONG_ID("DONG_ID")
		, DONG_NAME("DONG_NAME")
		, MGAHA_LGDNG_CD("MGAHA_LGDNG_CD")
		, CHANG_DAY("CHANG_DAY")
		, CHANG_DESC_TEXT("CHANG_DESC_TEXT")
		, LI_NAME("LI_NAME")
		, BMAS_ID("BMAS_ID")
		
		, SETL_ACC_NM("SETL_ACC_NM")
		, UP_SETL_ACC_ID("UP_SETL_ACC_ID")
		, SETL_ACC_TYPE_CD("SETL_ACC_TYPE_CD")
		, USE_YN("USE_YN")
		, FEE_CD_NM("FEE_CD_NM")
		
		, HNDSET_MODEL_ID("HNDSET_MODEL_ID")
		, PROD_TYPE_ID("PROD_TYPE_ID")
		, HNDSET_MODEL_NM("HNDSET_MODEL_NM")
		, ACTV_YN("ACTV_YN")
		, PLCY_INPUT_USE_YN("PLCY_INPUT_USE_YN")
		, MAKR_ID("MAKR_ID")
		, MOBIL_GEN_TYPE_ID("MOBIL_GEN_TYPE_ID")
		, MKNG_VNDR_ID("MKNG_VNDR_ID")
		, MOBIL_GEN_TYPE_CD("MOBIL_GEN_TYPE_CD")
		
		, REP_INTM_MODEL_ID("REP_INTM_MODEL_ID")
		, PROD_UCOST_EFCT_DT("PROD_UCOST_EFCT_DT")
		, EFCT_ST_DT("EFCT_ST_DT")
		, PROD_UCOST_EXP_DT("PROD_UCOST_EXP_DT")
		, EFCT_FNS_DT("EFCT_FNS_DT")
		, PROD_UCOST("PROD_UCOST")
		, INTM_AMT("INTM_AMT")
		
		, DEPTNUM("DEPTNUM")
		, NAME("NAME")
		, DIVNTYPEVAL("DIVNTYPEVAL")
		, ORG_TYPE_CD("ORG_TYPE_CD")
		, ORG_REL_TYPE_CD("ORG_REL_TYPE_CD")
		, UP_ORG_ID("UP_ORG_ID")
		, ORG_CLAS("ORG_CLAS")
		, OPTN_SYST_AGNCY_YN("OPTN_SYST_AGNCY_YN")
		, OPTN_SYST_AGNCY_ASIGN_DT("OPTN_SYST_AGNCY_ASIGN_DT")
		, PARDEPTNUM("PARDEPTNUM")
		, DIVNLEVEL("DIVNLEVEL")
		, CHANG_ORG_ID("CHANG_ORG_ID")
		
		, EAI_OP("EAI_OP")
		, DCID("DCID")
		, DCNM("DCNM")
		, DCLOBTYPECD("DCLOBTYPECD")
		, APRGDS_APLY_LOB_TYPE_CD("APRGDS_APLY_LOB_TYPE_CD")
		, DCSTTUSCD("DCSTTUSCD")
		
		, PRODID("PRODID")
		, PRODNM("PRODNM")
		, LOBTYPECD("LOBTYPECD")
		, PRODTYPECD("PRODTYPECD")
		, LEGACYPRODYN("LEGACYPRODYN")
		, PRODSTTUSCD("PRODSTTUSCD")
		, PRODCOMOTDATE("PRODCOMOTDATE")
		, PRODFNSDATE("PRODFNSDATE")
		, PRODBUYPRICMONTHFAMT("PRODBUYPRICMONTHFAMT")
		
		, USER_ID("USER_ID")
		, USER_NM("USER_NM")
		, USERNAME("USERNAME")
		, USER_TYPE_CD("USER_TYPE_CD")
		, USER_STTUS_CD("USER_STTUS_CD")
		, EMPSTATUS("EMPSTATUS")
		, USER_POS_ORG_ID("USER_POS_ORG_ID")
		, ORGCODE("ORGCODE")
		, TEL_NO("TEL_NO")
		, ADR("ADR")
		, EMAIL_ADR("EMAIL_ADR")
		, EMAIL("EMAIL")
		, HPNO("HPNO")
		, CLPOS_USER_DTL_REL_RMARK("CLPOS_USER_DTL_REL_RMARK")
		, OFPOS_USER_DTL_REL_RMARK("OFPOS_USER_DTL_REL_RMARK")
		, DUTY_USER_DTL_REL_RMARK("DUTY_USER_DTL_REL_RMARK")
		, ORG_USER_REL_EFCT_DT("ORG_USER_REL_EFCT_DT")
		, EXP_DT("EXP_DT")
		, CLASSCODE("CLASSCODE")
		, TITLECODE("TITLECODE")
		, JOBCODE("JOBCODE")
		
		, EV_ID("EV_ID")
		, EVENT_ID("EVENT_ID")
		, TRT_DT("TRT_DT")
		, EV_DATA_SBST("EV_DATA_SBST")
		, EV_STTUS_CD("EV_STTUS_CD")
		, EV_TYPE_ID("EV_TYPE_ID")
		
		, EAI_CRET_DT("EAI_CRET_DT")
		, LBLTY_AGNCY_ID("LBLTY_AGNCY_ID")
		
		, TRT_ORG_ID("TRT_ORG_ID")
		
		, EV_LOG_SRIAL_NO("EV_LOG_SRIAL_NO")
		, CPNT_EAI_SEQ("CPNT_EAI_SEQ")
		, VRF_DT("VRF_DT")
		, INGRS_CD("INGRS_CD")
		
		, TRT_AGNCY_ID("TRT_AGNCY_ID")
		
		, HOMDLV_CONF_DATE("HOMDLV_CONF_DATE")
		, INTM_CHG_TRT_ORG_ID("INTM_CHG_TRT_ORG_ID")
		
		, ACRU_TRT_GROUP_VAL("ACRU_TRT_GROUP_VAL")
		, EV_TRT_DIV_VAL("EV_TRT_DIV_VAL")
		
		, CLASS_CODE("CLASS_CODE")
		
		, guideDataId("guideDataId")
		, lob("lob")
		, factorAccountId("factorAccountId")
		, lastUpdateDate("lastUpdateDate")
		, firstOccurrenceDate("firstOccurrenceDate")
		, lastStateCd("lastStateCd")
		, orgId("orgId")
		, settlementTypeId("settlementTypeId")
		
		, REQ_DEPT_ID("REQ_DEPT_ID")
		, REQ_LOB_ID("REQ_LOB_ID")
		, REQ_SETTLEMENT_TYPE_ID("REQ_SETTLEMENT_TYPE_ID")
		, REQ_TARGET_DATE("REQ_TARGET_DATE")
		, REQ_BDGET_ORG_ID("REQ_BDGET_ORG_ID")
		
		, ORG_REL_ST_YM("ORG_REL_ST_YM")
		, ORG_REL_FNS_YM("ORG_REL_FNS_YM")
		, ORG_REL_ST_DT("ORG_REL_ST_DT")
		, ORG_REL_FNS_DT("ORG_REL_FNS_DT")
		, ACTIVEFLG("ACTIVEFLG")
		, HQ_ORG_ID("HQ_ORG_ID")
		, REGIONHEADID("REGIONHEADID")
		
		, EVENT_STATUS("EVENT_STATUS")
		, EVENT_GROUP_ID("EVENT_GROUP_ID")
		
		, orderSync("orderSync")
		, logSeq("logSeq")
		
		, HTTP_CONTENT_LENGTH("Content-Length")
		, HTTP_CONTENT_TYPE("Content-Type")
		, HTTP_SOAP_ACTION("SOAPAction")
		, HTTP_POST("POST")
		
		, setStatus("setStatus")
		, whereStatus("whereStatus")
		, targetStatus("targetStatus")
		
		, ORG_RFRN_FACTR_SEQ("ORG_RFRN_FACTR_SEQ")
		, TB_ORG_RFRN_FACTR_CTG("TB_ORG_RFRN_FACTR_CTG")
		, RFRN_FACTR_ID("RFRN_FACTR_ID")
		, EFCT_YM("EFCT_YM")
		, CLO_YM("CLO_YM")
		, TGT_YM("TGT_YM")
		, ACRU_DAT_RFRN_CLSN_ID("ACRU_DAT_RFRN_CLSN_ID")
		, RFRN_DATA_TYPE_CD("RFRN_DATA_TYPE_CD")
		, FACTR_ACC_ID("FACTR_ACC_ID")
		, ACRU_UPLD_APLY_STTUS_CD("ACRU_UPLD_APLY_STTUS_CD")
		, TLK_CASCNT("TLK_CASCNT")
		, OPN_AGNCY_ID("OPN_AGNCY_ID")
		
		, SUMDATA("SUMDATA")
		, POLICYID("POLICYID")
		, POLICYNM("POLICYNM")
		
		, APRGDS_BASE_PROD_ID("APRGDS_BASE_PROD_ID")
		, BASE_APRGDS_NM("BASE_APRGDS_NM")

		;
		
	
		private String value;
		private Name(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}	
	}
	public enum Value {
		  EmptyString("")
		, Y("Y")
		, N("N")
		, I("I")
		, J("J")
		, U("U")
		, D("D")
		, M("M")
		, H("H")
		, T("T")
		, S("S")
		, STR_0("0")
		, STR_1("1")
		, STR_2("2")
		, STR_3("3")
		, STR_4("4")
		, STR_9("4")
		, STR_00("00")
		, STR_29("29")
		, STR_10("10")
		, STR_11("11")
		, STR_12("12")
		, STR_22("22")
		, STR_25("25")
		, STR_100("100")
		, STR_103("103")
		, STR_105("105")
		, STR_200("200")
		, STR_201("201")
		, STR_700("700")
		, STR_999("999")
		, STR_109("109")
		

		, STR_19000101("19000101")
		, STR_999912("999912")
		, STR_99991231("99991231")
		, STR_01000000("01000000")
		, STR_000000("000000")
		, STR_235959("235959")
		
		, LEGAL("LEGAL")
		, limit("limit")
		, CMSN_CD("CMSN_CD")
		, PRODUCT("PRODUCT")
		, KT("KT")
		, MM("MM")
		, MC("MC")
		, KTMNS("KTMNS")
		, NULL("NULL")
		
		, WB("WB")
		, WF("WF")
		, PS("PS")
		, NT("NT")
		, MB("MB")
		, TV("TV")
		, IT("IT")
		, BD("BD")
		, SO("SO")
		
		, TRUE("true")
		, FALSE("false")
		
		, PENALTY("PENALTY")
		, AGN_AMT("AGN_AMT")
		, DSCNT_SR("DSCNT_SR")
		, NONODR("NONODR")
		, MOBIGO_MATCHED("MOBIGO_MATCHED")
		, PENLT_RMNY("PENLT_RMNY")
		, HOMDLV("HOMDLV")
		, SRTT("SRTT")
		, NON_PAYMENT("NON_PAYMENT")
		, LAYOFF("LAYOFF")
		, LIQUIDATION("LIQUIDATION")
		
		, OCCURS("OCCURS")
	
		, CHANNEL_FORM("CHANNEL;FORM")
		, S_NOTE_MATCHED("S_NOTE_MATCHED")
		
		, FAILED("FAILED")
		, FAIL("FAIL")
		, COMPLETE("COMPLETE")
		, DOWNREADY("DOWNREADY")
		
		, INPROGRESS("INPROGRESS")
		, NEW("NEW")
		, EXCEL("EXCEL")
		, ALL("ALL")
		
		, Active("Active")
		, Inactive("Inactive")
		
		, VAS("VAS")
		, DISCOUNT("DISCOUNT")
		, PLAN("PLAN")
		, DEVICE("DEVICE")
		
		, MARKET("MARKET")
		, PARTNER("PARTNER")
		, PARTNER_REL("PARTNER-REL")
		, SELLER("SELLER")
		, PTN_TRANS("PTN-TRANS")
		, NON_ORDER("NON-ORDER")
		, NON_ORDER_R_N("NON-ORDER_R_N")
		, NON_ORDER_R_F("NON-ORDER_R_F")
		, NON_ORDER_R_E("NON-ORDER_R_E")
		, BUSI_RECO("BUSI-RECO")
		, PTN_FROM_SETL("PTN-FROM-SETL")
		, PTN_AGNCY_LOB("PTN-AGNCY-LOB")
		, NRDS_SUCC_INFO("NRDS-SUCC-INFO")
		, LINED_MODEL("LINED-MODEL")
		, BUILDING("BUILDING")
		, AGNCY_CH("AGNCY_CH")
		, CPNT_CH("CPNT_CH")
		, AGNCY_CH_MAP("AGNCY_CH_MAP")
		, UNKNOWN("UNKNOWN")
		
		, MARKET_NS_OLD("marketingAreaSync")
		, PARTNER_NS_OLD("partnerInfoSync")
		, PARTNER_REL_NS_OLD("orgRelationSync")
		, SELLER_NS_OLD("sellerInfoSync")
		, PTN_TRANS_NS_OLD("syncPartnerTransferInfo")
		, NON_ORDER_NS_OLD("nonOrderSync")
		, ORDER_NS_OLD("orderSync")
		, BUSI_RECO_NS_OLD("businessRecordInfoRequest")
		
		, MARKET_NS("prm.kt.com/inf/service/ptn/SetMarketingArea")
		, PARTNER_NS("prm.kt.com/inf/service/ptn/SetPartnerInfo")
		, PARTNER_REL_NS("prm.kt.com/inf/service/ptn/SetOrgRelation")
		, SELLER_NS("prm.kt.com/inf/service/ptn/SetSellerInfo")
		, PTN_FROM_SETL_NS("prm.kt.com/inf/service/ptn/GetFormSetlInfo")
		, PTN_AGNCY_LOB_NS("prm.kt.com/inf/service/ptn/SetAgencyLob")
		, NRDS_SUCC_INFO_NS("prm.kt.com/inf/service/nrds/GetSuccessionInfo")
		, LINED_MODEL_NS("prm.kt.com/inf/service/mdm/SetLinedModel")
		, BUILDING_NS("prm.kt.com/inf/service/mdm/SetBuilding")
		, AGNCY_CH_NS("prm.kt.com/inf/service/mdm/SetAgencyChannel")
		, CPNT_CH_NS("prm.kt.com/inf/service/mdm/SetCpntChannel")
		, AGNCY_CH_MAP_NS("prm.kt.com/inf/service/mdm/SetAgencyChannelMapping")
		
		, WSNM_ORDER("/ws/orderSyncWebService")
		, WSNM_NON_ORDER("/ws/nonOrderSyncWebService")
		
		, ORDER("ORDER")
		, ORDER_BEFORE("ORDER_BEFORE") //PRM BEFORE로 들어온 데이터는 event를 남기지 않음
		, ORDER_NO_EVENT("ORDER_NO_EVENT") //PRM AFTER인데 tb_ev_ctg에 쌓을 데이터가 없을 때
		, ORDER_R_F("ORDER_R_F") //tb_ev_ctg에 쌓다가 에러날경우
		, ORDER_R_N("ORDER_R_N") //tb_ev_ctg에 쌓을 대상인데 ehcache가 문제가 생겨서 NONE일경우
		, ORDER_R_B("ORDER_R_B") //tb_ev_ctg에 쌓을 대상인데 접수(PRM BEFORE)가 없어서 처리조직과 처리사용자를 매핑 못할 때 
		, ORDER_R_D("ORDER_R_D") //tb_ev_ctg에 쌓을 대상인데 (Bundle) 단품의 개통일시가 tb_sale_cont_cret_txn에 없을 때
		, ORDER_R_E("ORDER_R_E") //재처리로 처리한 경우
		, ORDER_ERROR("ORDER_ERROR")
		
		, UTF_8("UTF-8")
		, yes("yes")
		, localhost("localhost")
		
		, TEMP("TEMP")
		, OP("OP")
		, C("C")
		, B("B")
		, NM("NM")
		, MD("MD")
		, RD("RD")
		, SS("SS")
		
		, UNDEFINED("UNDEFINED")
		, MNS("MNS")
		, SALE("SALE")
		, UNITE("UNITE")
		
		, ENTIRE("ENTIRE")
		, TRANSFER_FEE("TRANSFER_FEE")
		
		, HTTP_CONTENT_TYPE_UTF8("text/xml; charset=utf-8")
		
		, TKCAL_SUM("TKCAL_SUM")
		, RENAC("RENAC")

		
		, rowLimit(20000)
		, sheetLimit(10)
		
		
		;

		private String value;
		private int intValue;
		private Value(String value) {
			this.value = value;
		}
		private Value(int value) {
			this.intValue = value;
		}
		public String getValue() {
			return value;
		}
		public int getIntValue(){
			return intValue;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
		
	
}