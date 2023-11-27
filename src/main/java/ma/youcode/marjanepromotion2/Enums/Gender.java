package ma.youcode.marjanepromotion2.Enums;

import jakarta.persistence.AttributeConverter;
import lombok.Getter;

@Getter
public enum Gender {
    MALE("M"),
    FEMALE("F");

    private final String gender;

    Gender(String code) {this.gender = code;}

    public static Gender fromCode(String code) {
        switch (code) {
            case "F" -> {return FEMALE;}
            default -> {return MALE;}
        }
    }

    public static class AccessConverter implements AttributeConverter<Gender, String> {

        @Override
        public String convertToDatabaseColumn(Gender gender) {
            return gender == null ? null : gender.getGender();
        }

        @Override
        public Gender convertToEntityAttribute(String code) {
            return code == null ? null : fromCode(code);
        }
    }
}
