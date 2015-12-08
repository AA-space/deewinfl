package com.business.serviceImpl.Invoice;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.User;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.invoice.vat.TaxFundReceiptInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.service.Invoice.TaxFundReceiptService;
import com.business.service.fileTemplate.FileTemplateService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.serviceImpl.fileTemplate.DataMapCallBack;
import com.business.util.WorkflowUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.FileUtil;
import com.kernal.utils.MoneyUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.ResourceUtil;
import com.kernal.utils.SecurityUtil;
@Service(value="taxFundReceiptService")
public class TaxFundReceiptServiceIpml extends AbstractBaseServiceImpl implements TaxFundReceiptService {

	@Resource
    private BaseDao baseDao;
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name="fileTemplateService")
	private FileTemplateService  templateService;
	
	private String contractWordDir=ResourceUtil.getWordFilesRelativeStorePath();
	
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	
	@Override
	public void updateFundReceipt1(Map<String,String> model) throws Exception{
		String[] idsArray = model.get("ids").split(",");
		TaxFundReceiptInfo tri = null;
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		for (String id : idsArray) {
			ContractFundFundCharge cffc = this.tableService.findEntityByID(ContractFundFundCharge.class, id);
			if(cffc != null){
				tri = new TaxFundReceiptInfo();
				tri.setCffcId(cffc);
				tri.setContractId(cffc.getContractId());
				tri.setInvoiceStatus(2);
				tri.setFactDate(cffc.getFactDate());
				tri.setFactMoney(cffc.getFactMoney());
				tri.setPayObj(cffc.getFactObject());
				tri.setPayType(cffc.getFeeType());
				tri.setCreator(user);
				tri.setCreateDate(createDate);
				this.baseDao.saveEntity(tri);
			} else {
				tri = this.tableService.findEntityByID(TaxFundReceiptInfo.class, id);
				if(tri != null && tri.getInvoiceStatus() == 1){
					tri.setInvoiceStatus(2);
					this.baseDao.updateEntity(tri);
				}
			}
		}
	}
	
	@Override
	public void updateFundReceipt2(Map<String,String> model) throws Exception{
		String[] idsArray = model.get("ids").split(",");
		for (String id : idsArray) {
			TaxFundReceiptInfo tri = this.tableService.findEntityByID(TaxFundReceiptInfo.class, id);
			if(tri != null && tri.getInvoiceStatus() == 2){
				tri.setInvoiceStatus(3);
				this.baseDao.updateEntity(tri);
			}
		}
	}
	
	@Override
	public String updateFundReceipt3(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String[] idsArray = model.get("ids").replace("'", "").split(",");
		for (String id : idsArray) {
			TaxFundReceiptInfo tri = this.tableService.findEntityByID(TaxFundReceiptInfo.class, id);
			if(tri != null && tri.getInvoiceStatus() == 3){
				tri.setInvoiceStatus(4);
				this.baseDao.updateEntity(tri);
			}
		}
		
		String returnType=model.get("returnType");
		BaseFile bf=this.templateService.createFileByTemplateClass(model,new DataMapCallBack(){
			@Override
			public void dataMapCallBack(Map<String, Object> dataMap) throws Exception {
				ArrayList<ArrayList<Object>> receipt = (ArrayList<ArrayList<Object>>)dataMap.get("MS_Receipt");
				for(ArrayList<Object> lineData : receipt){
					Double money = Double.parseDouble(lineData.get(4).toString().trim());
					String moneyStr = MoneyUtil.amountToChinese(money==null?0:money);
					lineData.set(4, moneyStr);
					String num = WorkflowUtil.getInvoiceSerialNumber(null, baseDao.getHibernateTemplate(), baseDao.getJdbcTemplate());
					lineData.set(0, num);
				}
			}
		});
		
		if(returnType.equalsIgnoreCase("file")){
			this.templateService.addlogFileOper(bf, "下载");
			String browserType = model.get("browserType");
			String fileTitleName=bf.getFileName();
			if("firefox".equals(browserType)) {
				fileTitleName = new String(fileTitleName.getBytes("GB2312"),"ISO-8859-1");
			} else if("chrome".equals(browserType)) {
				fileTitleName = URLEncoder.encode(fileTitleName, "UTF-8");
			}  else if("safari".equals(browserType))  {
				fileTitleName = new String(fileTitleName.getBytes("UTF-8"),"ISO-8859-1");
			} else  {
				fileTitleName = URLEncoder.encode(fileTitleName, "UTF-8");
			}
			String uploadDirPath = FileUtil.getFilePathString(ResourceUtil.getFileUploadDataPath())+this.contractWordDir;
			String downloadedFileFullPath=uploadDirPath+"/"+bf.getFileRealAddress();
			downloadedFileFullPath=FileUtil.getFilePathString(downloadedFileFullPath);
			response.setHeader("Content-disposition","attachment; filename="+fileTitleName);
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			OutputStream      out  = response.getOutputStream();//(new File(downloadedFileFullPath));
			ResourceUtil.getFileUploadOperation().downloadFile(downloadedFileFullPath, out, null);
			return downloadedFileFullPath;
		}
		return null;
	}
	
	
	@Override
	public void updateFundReceiptForReturn(Map<String,String> model) throws Exception{
		String[] idsArray = model.get("ids").split(",");
		for (String id : idsArray) {
			TaxFundReceiptInfo tri = this.tableService.findEntityByID(TaxFundReceiptInfo.class, id);
			if(tri != null){
				if(tri.getInvoiceStatus() > 0){
					tri.setInvoiceStatus(tri.getInvoiceStatus() - 1);
					this.baseDao.updateEntity(tri);
				}
			}
		}
	}
}
