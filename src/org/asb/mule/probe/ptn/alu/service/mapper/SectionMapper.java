package org.asb.mule.probe.ptn.alu.service.mapper;

import globaldefs.NameAndStringValue_T;

import org.asb.mule.probe.framework.entity.Section;
import org.asb.mule.probe.framework.util.CodeTool;

import topologicalLink.TopologicalLink_T;

public class SectionMapper extends CommonMapper

{
	private static SectionMapper instance;

	public static SectionMapper instance() {
		if (instance == null) {
			instance = new SectionMapper();
		}
		return instance;
	}

	public Section convertSection(TopologicalLink_T vendorEntity) {

		Section section = new Section();
		section.setDn(nv2dn(vendorEntity.name));
		section.setEmsName(vendorEntity.name[0].value);
		section.setNativeEMSName(CodeTool.isoToGbk(vendorEntity.nativeEMSName));
		section.setUserLabel(CodeTool.isoToGbk(vendorEntity.userLabel));
		section.setDirection(mapperConnectionDirection(vendorEntity.direction));
		section.setaEndTP(nv2dn(vendorEntity.aEndTP));
		section.setzEndTP(nv2dn(vendorEntity.zEndTP));
		section.setRate(vendorEntity.rate + "");
		section.setAdditionalInfo(mapperAdditionalInfo(vendorEntity.additionalInfo));
		return section;
	}

}
