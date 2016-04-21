//package com.dragonfly.timemachine.domain;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.MappedSuperclass;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//
//import org.hibernate.validator.constraints.NotBlank;
//
//
//@MappedSuperclass
//public abstract class NamedModel extends Model {
//
//	public final static String NAME_PATTERN = "[A-Za-z][A-Za-z0-9_.[-]]+";
//    public static final int NAME_MIN_LENGTH = 2;
//    public static final int NAME_MAX_LENGTH = 50;
//    public static final int DISPLAY_NAME_MIN_LENGTH = 1;
//    public static final int DISPLAY_NAME_MAX_LENGTH = 500;
//    public static final int DESCRIPTION_MAX_LENGTH = 2000;
//
//    @NotBlank
//    @Column(name = "NAME")
//    @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH)
//    @Pattern(regexp = NAME_PATTERN, message = "may only contain ASCII letters, numbers, underscores, dashes, and dots but must start with a ASCII letter")
//    protected String name;
//
//	@NotBlank
//    @Column(name = "DISPLAY_NAME")
//    @Size(min = DISPLAY_NAME_MIN_LENGTH, max = DISPLAY_NAME_MAX_LENGTH)
//    protected String displayName;
//
//    @Column(name = "DESCRIPTION")
//    @Size(max = DESCRIPTION_MAX_LENGTH)
//    protected String description;
//
//    protected NamedModel() {
//
//    }
//
//    protected NamedModel(String name, String displayName, String description) {
//        super();
//        this.name = name;
//        this.displayName = displayName;
//        this.description = description;
//    }
//
//    public static List<String> names(List<? extends NamedModel> modelList) {
//        List<String> nameList = new ArrayList<String>();
//        for (NamedModel namedModel : modelList) {
//            nameList.add(namedModel.getName());
//        }
//        return nameList;
//    }
//    
//
//    public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDisplayName() {
//		return displayName;
//	}
//
//	public void setDisplayName(String displayName) {
//		this.displayName = displayName;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public static String getNamePattern() {
//		return NAME_PATTERN;
//	}
//
//	public static int getNameMinLength() {
//		return NAME_MIN_LENGTH;
//	}
//
//	public static int getNameMaxLength() {
//		return NAME_MAX_LENGTH;
//	}
//
//	public static int getDisplayNameMinLength() {
//		return DISPLAY_NAME_MIN_LENGTH;
//	}
//
//	public static int getDisplayNameMaxLength() {
//		return DISPLAY_NAME_MAX_LENGTH;
//	}
//
//	public static int getDescriptionMaxLength() {
//		return DESCRIPTION_MAX_LENGTH;
//	}
//
//}