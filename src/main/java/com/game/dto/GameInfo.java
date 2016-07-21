package com.game.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GameInfo {
@Id
@GeneratedValue
private int no;
private String gameName;
private String size;
private String version;
private String packageName;
private String downloadLink;

public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getGameName() {
	return gameName;
}
public void setGameName(String gameName) {
	this.gameName = gameName;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
public String getPackageName() {
	return packageName;
}
public void setPackageName(String packageName) {
	this.packageName = packageName;
}
public String getDownloadLink() {
	return downloadLink;
}
public void setDownloadLink(String downloadLink) {
	this.downloadLink = downloadLink;
}


}
