package pl.pracainzynierska.backend.model.DTO;

import java.util.List;

public class BoulderDto {


    private String name;
    private Integer grade;
    private List<HoldDto> holdDtoList;
    private String author;
    private Long iD;

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public List<HoldDto> getHoldDtoList() {
        return holdDtoList;
    }

    public void setHoldDtoList(List<HoldDto> holdDtoList) {
        this.holdDtoList = holdDtoList;
    }

    public BoulderDto(String name, Integer grade, List<HoldDto> holdDtoList, String author, Long iD) {
        this.name = name;
        this.grade = grade;
        this.author = author;
        this.holdDtoList = holdDtoList;
        this.iD =iD;
    }

    public BoulderDto(){

    }
}
