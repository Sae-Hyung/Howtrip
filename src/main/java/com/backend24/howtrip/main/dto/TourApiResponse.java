package com.backend24.howtrip.main.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class TourApiResponse {
        @XmlElement(name = "header")
        private Header header;
        @XmlElement(name = "body")
        private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
        public static class Header {
            @XmlElement(name = "resultCode")
            private String resultCode;
            @XmlElement(name = "resultMsg")
            private String resultMsg;

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }
    }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Body {
            @XmlElement(name = "items")
            private Items items;
            @XmlElement(name = "numOfRows")
            private int numOfRows;
            @XmlElement(name = "pageNo")
            private int pageNo;
            @XmlElement(name = "totalCount")
            private int totalCount;

            public Items getItems() {
                return items;
            }

            public void setItems(Items items) {
                this.items = items;
            }

            public int getNumOfRows() {
                return numOfRows;
            }

            public void setNumOfRows(int numOfRows) {
                this.numOfRows = numOfRows;
            }

            public int getPageNo() {
                return pageNo;
            }

            public void setPageNo(int pageNo) {
                this.pageNo = pageNo;
            }

            public int getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            public static class Items {
                @XmlElement(name = "item")
                private List<Item> itemList;

                public List<Item> getItemList() {
                    return itemList;
                }

                public void setItemList(List<Item> itemList) {
                    this.itemList = itemList;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                public static class Item {
                    @XmlElement(name = "addr1")
                    private String addr1;
                    @XmlElement(name = "addr2")
                    private String addr2;
                    @XmlElement(name = "areacode")
                    private String areacode;
                    @XmlElement(name = "booktour")
                    private String booktour;
                    @XmlElement(name = "cat1")
                    private String cat1;
                    @XmlElement(name = "cat2")
                    private String cat2;
                    @XmlElement(name = "cat3")
                    private String cat3;
                    @XmlElement(name = "contentid")
                    private String contentid;
                    @XmlElement(name = "contenttypeid")
                    private String contenttypeid;
                    @XmlElement(name = "createdtime")
                    private String createdtime;
                    @XmlElement(name = "dist")
                    private double dist;
                    @XmlElement(name = "firstimage")
                    private String firstimage;
                    @XmlElement(name = "firstimage2")
                    private String firstimage2;
                    @XmlElement(name = "cpyrhtDivCd")
                    private String cpyrhtDivCd;
                    @XmlElement(name = "mapx")
                    private double mapx;
                    @XmlElement(name = "mapy")
                    private double mapy;
                    @XmlElement(name = "mlevel")
                    private int mlevel;
                    @XmlElement(name = "modifiedtime")
                    private String modifiedtime;
                    @XmlElement(name = "sigungucode")
                    private String sigungucode;
                    @XmlElement(name = "tel")
                    private String tel;
                    @XmlElement(name = "title")
                    private String title;

                    public String getAddr1() {
                        return addr1;
                    }

                    public void setAddr1(String addr1) {
                        this.addr1 = addr1;
                    }

                    public String getAddr2() {
                        return addr2;
                    }

                    public void setAddr2(String addr2) {
                        this.addr2 = addr2;
                    }

                    public String getAreacode() {
                        return areacode;
                    }

                    public void setAreacode(String areacode) {
                        this.areacode = areacode;
                    }

                    public String getBooktour() {
                        return booktour;
                    }

                    public void setBooktour(String booktour) {
                        this.booktour = booktour;
                    }

                    public String getCat1() {
                        return cat1;
                    }

                    public void setCat1(String cat1) {
                        this.cat1 = cat1;
                    }

                    public String getCat2() {
                        return cat2;
                    }

                    public void setCat2(String cat2) {
                        this.cat2 = cat2;
                    }

                    public String getCat3() {
                        return cat3;
                    }

                    public void setCat3(String cat3) {
                        this.cat3 = cat3;
                    }

                    public String getContentid() {
                        return contentid;
                    }

                    public void setContentid(String contentid) {
                        this.contentid = contentid;
                    }

                    public String getContenttypeid() {
                        return contenttypeid;
                    }

                    public void setContenttypeid(String contenttypeid) {
                        this.contenttypeid = contenttypeid;
                    }

                    public String getCreatedtime() {
                        return createdtime;
                    }

                    public void setCreatedtime(String createdtime) {
                        this.createdtime = createdtime;
                    }

                    public double getDist() {
                        return dist;
                    }

                    public void setDist(double dist) {
                        this.dist = dist;
                    }

                    public String getFirstimage() {
                        return firstimage;
                    }

                    public void setFirstimage(String firstimage) {
                        this.firstimage = firstimage;
                    }

                    public String getFirstimage2() {
                        return firstimage2;
                    }

                    public void setFirstimage2(String firstimage2) {
                        this.firstimage2 = firstimage2;
                    }

                    public String getCpyrhtDivCd() {
                        return cpyrhtDivCd;
                    }

                    public void setCpyrhtDivCd(String cpyrhtDivCd) {
                        this.cpyrhtDivCd = cpyrhtDivCd;
                    }

                    public double getMapx() {
                        return mapx;
                    }

                    public void setMapx(double mapx) {
                        this.mapx = mapx;
                    }

                    public double getMapy() {
                        return mapy;
                    }

                    public void setMapy(double mapy) {
                        this.mapy = mapy;
                    }

                    public int getMlevel() {
                        return mlevel;
                    }

                    public void setMlevel(int mlevel) {
                        this.mlevel = mlevel;
                    }

                    public String getModifiedtime() {
                        return modifiedtime;
                    }

                    public void setModifiedtime(String modifiedtime) {
                        this.modifiedtime = modifiedtime;
                    }

                    public String getSigungucode() {
                        return sigungucode;
                    }

                    public void setSigungucode(String sigungucode) {
                        this.sigungucode = sigungucode;
                    }

                    public String getTel() {
                        return tel;
                    }

                    public void setTel(String tel) {
                        this.tel = tel;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }
            }
        }
    }