package com.sz.mangosteeneg.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Time:2021/5/14 16:05
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:
 */
public class CityAreasBean implements Serializable{

    private int resultCode;
    private String resultMsg;
    private int errCode;
    private boolean success;
    private DataBean data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * firstLetter : A
             * provinceWithCityModels : [{"id":14206,"firstLetter":null,"name":"安徽省","code":"340000","cities":null,"cityWithFirstLetterModels":[{"firstLetter":"A","cities":[{"code":"340800","name":"安庆市","longitude":"117.06354","latitude":"30.54294","areas":[{"firstLetter":"Y","code":"340802","name":"迎江区"},{"firstLetter":"D","code":"340803","name":"大观区"},{"firstLetter":"Y","code":"340811","name":"宜秀区"},{"firstLetter":"H","code":"340822","name":"怀宁县"},{"firstLetter":"Q","code":"340824","name":"潜山县"},{"firstLetter":"T","code":"340825","name":"太湖县"},{"firstLetter":"S","code":"340826","name":"宿松县"},{"firstLetter":"W","code":"340827","name":"望江县"},{"firstLetter":"Y","code":"340828","name":"岳西县"},{"firstLetter":"T","code":"340881","name":"桐城市"}]}]},{"firstLetter":"B","cities":[{"code":"340300","name":"蚌埠市","longitude":"117.38932","latitude":"32.91548","areas":[{"firstLetter":"L","code":"340302","name":"龙子湖区"},{"firstLetter":"B","code":"340303","name":"蚌山区"},{"firstLetter":"Y","code":"340304","name":"禹会区"},{"firstLetter":"H","code":"340311","name":"淮上区"},{"firstLetter":"H","code":"340321","name":"怀远县"},{"firstLetter":"W","code":"340322","name":"五河县"},{"firstLetter":"G","code":"340323","name":"固镇县"}]},{"code":"341600","name":"亳州市","longitude":"115.77931","latitude":"33.84461","areas":[{"firstLetter":"Q","code":"341602","name":"谯城区"},{"firstLetter":"W","code":"341621","name":"涡阳县"},{"firstLetter":"M","code":"341622","name":"蒙城县"},{"firstLetter":"L","code":"341623","name":"利辛县"}]}]},{"firstLetter":"C","cities":[{"code":"341100","name":"滁州市","longitude":"118.31683","latitude":"32.30181","areas":[{"firstLetter":"L","code":"341102","name":"琅琊区"},{"firstLetter":"N","code":"341103","name":"南谯区"},{"firstLetter":"L","code":"341122","name":"来安县"},{"firstLetter":"Q","code":"341124","name":"全椒县"},{"firstLetter":"D","code":"341125","name":"定远县"},{"firstLetter":"F","code":"341126","name":"凤阳县"},{"firstLetter":"T","code":"341181","name":"天长市"},{"firstLetter":"M","code":"341182","name":"明光市"}]},{"code":"341700","name":"池州市","longitude":"117.49142","latitude":"30.66469","areas":[{"firstLetter":"G","code":"341702","name":"贵池区"},{"firstLetter":"D","code":"341721","name":"东至县"},{"firstLetter":"S","code":"341722","name":"石台县"},{"firstLetter":"Q","code":"341723","name":"青阳县"}]}]},{"firstLetter":"F","cities":[{"code":"341200","name":"阜阳市","longitude":"115.81495","latitude":"32.88963","areas":[{"firstLetter":"Y","code":"341202","name":"颍州区"},{"firstLetter":"Y","code":"341203","name":"颍东区"},{"firstLetter":"Y","code":"341204","name":"颍泉区"},{"firstLetter":"L","code":"341221","name":"临泉县"},{"firstLetter":"T","code":"341222","name":"太和县"},{"firstLetter":"F","code":"341225","name":"阜南县"},{"firstLetter":"Y","code":"341226","name":"颍上县"},{"firstLetter":"J","code":"341282","name":"界首市"}]}]},{"firstLetter":"H","cities":[{"code":"340100","name":"合肥市","longitude":"117.22901","latitude":"31.82057","areas":[{"firstLetter":"Y","code":"340102","name":"瑶海区"},{"firstLetter":"L","code":"340103","name":"庐阳区"},{"firstLetter":"S","code":"340104","name":"蜀山区"},{"firstLetter":"B","code":"340111","name":"包河区"},{"firstLetter":"Z","code":"340121","name":"长丰县"},{"firstLetter":"F","code":"340122","name":"肥东县"},{"firstLetter":"F","code":"340123","name":"肥西县"},{"firstLetter":"L","code":"340124","name":"庐江县"},{"firstLetter":"C","code":"340181","name":"巢湖市"}]},{"code":"340400","name":"淮南市","longitude":"116.9998","latitude":"32.62549","areas":[{"firstLetter":"D","code":"340402","name":"大通区"},{"firstLetter":"T","code":"340403","name":"田家庵区"},{"firstLetter":"X","code":"340404","name":"谢家集区"},{"firstLetter":"B","code":"340405","name":"八公山区"},{"firstLetter":"P","code":"340406","name":"潘集区"},{"firstLetter":"F","code":"340421","name":"凤台县"},{"firstLetter":"S","code":"340422","name":"寿县"}]},{"code":"340600","name":"淮北市","longitude":"116.79834","latitude":"33.95479","areas":[{"firstLetter":"D","code":"340602","name":"杜集区"},{"firstLetter":"X","code":"340603","name":"相山区"},{"firstLetter":"L","code":"340604","name":"烈山区"},{"firstLetter":"S","code":"340621","name":"濉溪县"}]},{"code":"341000","name":"黄山市","longitude":"118.33866","latitude":"29.71517","areas":[{"firstLetter":"T","code":"341002","name":"屯溪区"},{"firstLetter":"H","code":"341003","name":"黄山区"},{"firstLetter":"H","code":"341004","name":"徽州区"},{"firstLetter":"S","code":"341021","name":"歙县"},{"firstLetter":"X","code":"341022","name":"休宁县"},{"firstLetter":"Y","code":"341023","name":"黟县"},{"firstLetter":"Q","code":"341024","name":"祁门县"}]}]},{"firstLetter":"L","cities":[{"code":"341500","name":"六安市","longitude":"116.52324","latitude":"31.73488","areas":[{"firstLetter":"J","code":"341502","name":"金安区"},{"firstLetter":"Y","code":"341503","name":"裕安区"},{"firstLetter":"Y","code":"341504","name":"叶集区"},{"firstLetter":"H","code":"341522","name":"霍邱县"},{"firstLetter":"S","code":"341523","name":"舒城县"},{"firstLetter":"J","code":"341524","name":"金寨县"},{"firstLetter":"H","code":"341525","name":"霍山县"}]}]},{"firstLetter":"M","cities":[{"code":"340500","name":"马鞍山市","longitude":"118.50611","latitude":"31.67067","areas":[{"firstLetter":"H","code":"340503","name":"花山区"},{"firstLetter":"Y","code":"340504","name":"雨山区"},{"firstLetter":"B","code":"340506","name":"博望区"},{"firstLetter":"D","code":"340521","name":"当涂县"},{"firstLetter":"H","code":"340522","name":"含山县"},{"firstLetter":"H","code":"340523","name":"和县"}]}]},{"firstLetter":"S","cities":[{"code":"341300","name":"宿州市","longitude":"116.96391","latitude":"33.64614","areas":[{"firstLetter":"Y","code":"341302","name":"埇桥区"},{"firstLetter":"D","code":"341321","name":"砀山县"},{"firstLetter":"X","code":"341322","name":"萧县"},{"firstLetter":"L","code":"341323","name":"灵璧县"},{"firstLetter":"S","code":"341324","name":"泗县"}]}]},{"firstLetter":"T","cities":[{"code":"340700","name":"铜陵市","longitude":"117.81232","latitude":"30.94486","areas":[{"firstLetter":"T","code":"340705","name":"铜官区"},{"firstLetter":"Y","code":"340706","name":"义安区"},{"firstLetter":"J","code":"340711","name":"郊区"},{"firstLetter":"Z","code":"340722","name":"枞阳县"}]}]},{"firstLetter":"W","cities":[{"code":"340200","name":"芜湖市","longitude":"118.43313","latitude":"31.35246","areas":[{"firstLetter":"J","code":"340202","name":"镜湖区"},{"firstLetter":"Y","code":"340203","name":"弋江区"},{"firstLetter":"J","code":"340207","name":"鸠江区"},{"firstLetter":"S","code":"340208","name":"三山区"},{"firstLetter":"W","code":"340221","name":"芜湖县"},{"firstLetter":"F","code":"340222","name":"繁昌县"},{"firstLetter":"N","code":"340223","name":"南陵县"},{"firstLetter":"W","code":"340225","name":"无为县"}]}]},{"firstLetter":"X","cities":[{"code":"341800","name":"宣城市","longitude":"118.75866","latitude":"30.94078","areas":[{"firstLetter":"X","code":"341802","name":"宣州区"},{"firstLetter":"L","code":"341821","name":"郎溪县"},{"firstLetter":"G","code":"341822","name":"广德县"},{"firstLetter":"J","code":"341823","name":"泾县"},{"firstLetter":"J","code":"341824","name":"绩溪县"},{"firstLetter":"J","code":"341825","name":"旌德县"},{"firstLetter":"N","code":"341881","name":"宁国市"}]}]}]},{"id":46181,"firstLetter":null,"name":"澳门特别行政区","code":"820000","cities":null,"cityWithFirstLetterModels":[]}]
             */

            private String firstLetter;
            private List<ProvinceWithCityModelsBean> provinceWithCityModels;

            public String getFirstLetter() {
                return firstLetter;
            }

            public void setFirstLetter(String firstLetter) {
                this.firstLetter = firstLetter;
            }

            public List<ProvinceWithCityModelsBean> getProvinceWithCityModels() {
                return provinceWithCityModels;
            }

            public void setProvinceWithCityModels(List<ProvinceWithCityModelsBean> provinceWithCityModels) {
                this.provinceWithCityModels = provinceWithCityModels;
            }

            public static class ProvinceWithCityModelsBean implements Serializable {

                private int id;
                private String firstLetter;
                private String name;
                private String code;
                private String cities;
                private List<CityWithFirstLetterModelsBean> cityWithFirstLetterModels;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getCities() {
                    return cities;
                }

                public void setCities(String cities) {
                    this.cities = cities;
                }

                public List<CityWithFirstLetterModelsBean> getCityWithFirstLetterModels() {
                    return cityWithFirstLetterModels;
                }

                public void setCityWithFirstLetterModels(List<CityWithFirstLetterModelsBean> cityWithFirstLetterModels) {
                    this.cityWithFirstLetterModels = cityWithFirstLetterModels;
                }

                public static class CityWithFirstLetterModelsBean implements Serializable {

                    private String firstLetter;
                    private List<CitiesBean> cities;

                    public String getFirstLetter() {
                        return firstLetter;
                    }

                    public void setFirstLetter(String firstLetter) {
                        this.firstLetter = firstLetter;
                    }

                    public List<CitiesBean> getCities() {
                        return cities;
                    }

                    public void setCities(List<CitiesBean> cities) {
                        this.cities = cities;
                    }

                    public static class CitiesBean implements Serializable {

                        private String code;
                        private String name;
                        private String longitude;
                        private String latitude;
                        private List<AreasBean> areas;

                        public String getCode() {
                            return code;
                        }

                        public void setCode(String code) {
                            this.code = code;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getLongitude() {
                            return longitude;
                        }

                        public void setLongitude(String longitude) {
                            this.longitude = longitude;
                        }

                        public String getLatitude() {
                            return latitude;
                        }

                        public void setLatitude(String latitude) {
                            this.latitude = latitude;
                        }

                        public List<AreasBean> getAreas() {
                            return areas;
                        }

                        public void setAreas(List<AreasBean> areas) {
                            this.areas = areas;
                        }

                        public static class AreasBean implements Serializable {

                            private String firstLetter;
                            private String code;
                            private String name;

                            public String getFirstLetter() {
                                return firstLetter;
                            }

                            public void setFirstLetter(String firstLetter) {
                                this.firstLetter = firstLetter;
                            }

                            public String getCode() {
                                return code;
                            }

                            public void setCode(String code) {
                                this.code = code;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }
                }
            }
        }
    }
}