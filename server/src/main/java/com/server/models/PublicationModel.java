package com.server.models;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "publications")

public class PublicationModel {

    public String _id;
    public String title;
    public String description;
    public String bannerImg;
    public String author;
    public String authorId;
    public String domain;
    public List<String> keywords;
    public String publishedDate;
    public String pdfFileName;
    public String evaluator;
    public String evaluatorId;
    public String evaluationDate;
    public String evaluationNote;
    public String status;

    public PublicationModel(){}

    public String get_id() {
        return _id;
    }
    
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }   

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator;
    }

    public String getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(String evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public String getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(String evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getEvaluationNote() {
        return evaluationNote;
    }

    public void setEvaluationNote(String evaluationNote) {
        this.evaluationNote = evaluationNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PublicationModel [_id=" + _id + ", author=" + author + ", authorId=" + authorId + ", bannerImg="
                + bannerImg + ", description=" + description + ", domain=" + domain + ", evaluationDate="
                + evaluationDate + ", evaluationNote=" + evaluationNote + ", evaluator=" + evaluator + ", evaluatorId="
                + evaluatorId + ", pdfFileName=" + pdfFileName + ", publishedDate="
                + publishedDate + ", status=" + status + ", title=" + title + "]";
    }
    
}
