package gov.usgs.wma.qw.codes.webservices;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import gov.usgs.wma.qw.BaseRestController;
import gov.usgs.wma.qw.LastUpdateDao;
import gov.usgs.wma.qw.codes.Code;
import gov.usgs.wma.qw.codes.CodeList;
import gov.usgs.wma.qw.codes.CodeType;
import gov.usgs.wma.qw.codes.dao.CodeDao;
import gov.usgs.wma.qw.springinit.ConfigOpenApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Assemblage", description=ConfigOpenApi.LOOKUP_TAG_DESCRIPTION)
@RestController
@RequestMapping(value="assemblage", produces={BaseRestController.MEDIA_TYPE_APPLICATION_XML_UTF8_VALUE, BaseRestController.MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE})
public class AssemblageRestController extends CodesRestController {
	private static final Logger LOG = LoggerFactory.getLogger(CharacteristicNameRestController.class);

	@Autowired
	public AssemblageRestController(final LastUpdateDao lastUpdateDao, final CodeDao codeDao) {
		this.lastUpdateDao = lastUpdateDao;
		this.codeDao = codeDao;
	}

	@Operation(description="Return a filtered and paged list of valid Assemblages.")
	@GetMapping()
	public CodeList getAssemblageNames(final @RequestParam(value="text", required=false) String text,
			final @RequestParam(value="pagenumber", required=false) String pageNumber,
			final @RequestParam(value="pagesize", required=false) String pageSize,
			WebRequest webRequest) {
		LOG.debug("assemblageNames");
		return getList(CodeType.ASSEMBLAGE, text, pageNumber, pageSize, null, webRequest);
	}

	@Operation(description="Validate and return the requested Assemblage.")
	@GetMapping("/validate")
	public Code getAssemblageName(final @RequestParam(value="value") String value,
			WebRequest webRequest, HttpServletResponse response) {
		LOG.debug("assemblageName");
		return getCode(CodeType.ASSEMBLAGE, value, webRequest, response);
	}

}
