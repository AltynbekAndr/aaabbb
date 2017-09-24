package com.springapp.mvc.service;


import com.springapp.mvc.models.Success;
import com.springapp.mvc.models_test.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Repository
@Transactional
public class MyServiceClass {

    /* @Autowired
     @Qualifier(value = "sessionFactoryDistant")
     SessionFactory sessionFactoryDistant;
     @Autowired
     @Qualifier(value = "sessionFactoryLocalDb")
     SessionFactory sessionFactoryLocalDb;
     */
   @Autowired
   SessionFactory mainsessionFactory;
   Calendar c = Calendar.getInstance();

    public Object search(Abonent abonent){
        if(abonent!=null&&
                (
                (abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0)
                ||
                (abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0)
                ||
                (abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0)
                ||
                (abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0)
                ||
                (abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0)
                )
                ){
            Criteria criteria = mainsessionFactory.getCurrentSession().createCriteria(Abonent.class);
            if(abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0){
                criteria.add(Restrictions.eq("cspot",abonent.getCspot()));
                Abonent a = (Abonent)criteria.uniqueResult();
                if(a!=null){
                    return a;
                }
            }
            if(abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0){
                criteria.add(Restrictions.like("cspot2",abonent.getCspot2()));
            }if(abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0){
                criteria.add(Restrictions.like("address1",abonent.getAddress1()));
            }if(abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0){
                criteria.add(Restrictions.like("address2",abonent.getAddress2()));
            }if(abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0){
                criteria.add(Restrictions.like("nregion",abonent.getNregion()));
            }
            List result_search = criteria.list();
            if(result_search!=null&&result_search.size()!=0){
                return result_search;
            }

        }
        return null;
    }






    public Success otkluchenie(Abonent abonent) {
       if(abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0&&abonent.getNamitype()!=null&&abonent.getNamitype()!=""&&abonent.getNamitype().length()!=0){
          if(abonent.getNamitype().equals("1")){
              Criteria criteria = mainsessionFactory.getCurrentSession().createCriteria(Counterr.class);
              criteria.add(Restrictions.eq("ls",abonent.getCspot()));
              Counterr cnt = (Counterr)criteria.uniqueResult();
              if(cnt==null){
                  Counterr counterr = new Counterr();
                      if(abonent.getDgarb()!=null){
                          counterr.setComand(abonent.getDgarb());
                      }if(abonent.getCspot()!=null){
                          counterr.setLs(abonent.getCspot());
                      }if(abonent.getNregion()!=null){
                          counterr.setRaion(abonent.getNregion());
                      }if(abonent.getCspot2()!=null){
                          counterr.setFio_customer(abonent.getCspot2());
                      }if(abonent.getCcounter()!=null){
                          counterr.setCounters(abonent.getCcounter());
                      }if(abonent.getAddress1()!=null){
                          counterr.setAdress(abonent.getAddress1());
                      }if(abonent.getAddress2()!=null){
                          counterr.setDom(abonent.getAddress2());
                      }
                              counterr.setUsers("altynbek");
                              counterr.setTimesend(c.getTime().toString());

                                      mainsessionFactory.getCurrentSession().save(counterr);
                                      Success success = new Success();
                                      success.setResult(200);
                                      return success;

                                                  }else{
                                                      Success success = new Success();
                                                      success.setResult(300);
                                                      return success;
                                                  }
          }else if(abonent.getNamitype().equals("2")||abonent.getNamitype().equals("4")){
              Criteria criteria = mainsessionFactory.getCurrentSession().createCriteria(Chinameters.class);
              criteria.add(Restrictions.eq("cust_code",abonent.getCspot()));
              Chinameters chch = (Chinameters)criteria.uniqueResult();
                  if(chch==null){
                      Chinameters chinameters = new Chinameters();
                      if(abonent.getCcounter()!=null){
                          chinameters.setMeter_no(abonent.getCcounter());
                      }if(abonent.getNregion()!=null){
                          chinameters.setRegion(abonent.getNregion());
                      }if(abonent.getDgarb()!=null){
                          chinameters.setCommand(abonent.getDgarb());
                      }if(abonent.getCcounter2()!=null){
                          chinameters.setMeter_type(abonent.getCcounter2());
                      }if(abonent.getCcounter20()!=null){
                          chinameters.setType_mvalue(abonent.getCcounter20());
                      }if(abonent.getCspot2()!=null){
                          chinameters.setCust_name(abonent.getCspot2());
                      }if(abonent.getCspot()!=null){
                          chinameters.setCust_code(abonent.getCspot());
                      }if(abonent.getAddress1()!=null){
                          chinameters.setCust_adr1(abonent.getAddress1());
                      }if(abonent.getAddress2()!=null){
                          chinameters.setCust_adr2(abonent.getAddress2());
                      }
                              chinameters.setUser_name("altynbek");
                              chinameters.setTimesend(c.getTime().toString());

                                                          mainsessionFactory.getCurrentSession().save(chinameters);
                                                          Success success = new Success();
                                                          success.setResult(200);
                                                          return success;

              }else{
                  Success success = new Success();
                  success.setResult(300);
                  return success;
              }
          }
       }
       Success success = new Success();
       success.setResult(100);

       return success;
   }
    public Success podkluchenie(Abonent abonent){
        Success success = new Success();
        if(abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0){

                Criteria criteria = mainsessionFactory.getCurrentSession().createCriteria(Counterr.class);
                criteria.add(Restrictions.eq("ls",abonent.getCspot()));
                Counterr cnt = (Counterr)criteria.uniqueResult();
                    if(cnt!=null){
                        mainsessionFactory.getCurrentSession().delete(cnt);
                        success.setResult(200);
                        return success;
                    }
                Criteria criteria2 = mainsessionFactory.getCurrentSession().createCriteria(Chinameters.class);
                criteria2.add(Restrictions.eq("cust_code",abonent.getCspot()));
                Chinameters cnch = (Chinameters)criteria2.uniqueResult();
                    if(cnch!=null){
                        mainsessionFactory.getCurrentSession().delete(cnch);
                        success.setResult(200);
                        return success;
                    }else{
                        success.setResult(300);
                        return success;
                    }

        }
        success.setResult(100);
        return success;
    }

    public List getList(int i,int k){
        Criteria criteria = mainsessionFactory.getCurrentSession().createCriteria(Chinameters.class);

        criteria.setFirstResult(i);
        criteria.setMaxResults(k);

        List l = criteria.list();

        return l;
    }
    public List getList2(int i,int k){
        Criteria criteria = mainsessionFactory.getCurrentSession().createCriteria(Counterr.class);
        criteria.setFirstResult(i);
        criteria.setMaxResults(k);
        List l =criteria.list();
        return l;
    }



    public Success signIn(User user){
        User resultUser;
        if (user!=null&&user.getName()!=null&&user.getName()!=""&&user.getPassword()!=null&&user.getPassword()!=""){
            Criteria  criteria = mainsessionFactory.getCurrentSession().createCriteria(User.class);
            criteria.add(Restrictions.eq("name",user.getName()));
            criteria.add(Restrictions.eq("password",user.getPassword()));
            resultUser = (User) criteria.uniqueResult();
            if(resultUser!=null){
                Success success = new Success();
                success.setResult(200);
                return success;
            }
            Success success = new Success();
            success.setResult(100);
            return success;
        }
        Success success = new Success();
        success.setResult(100);
        return success;
    }
    public Success setuser(User user){
        if(user!=null){
            mainsessionFactory.getCurrentSession().save(user);
                Success success = new Success();
                success.setResult(200);
                return success;
        }

        Success success = new Success();
        success.setResult(100);
        return success;
    }

    public Object searchOff(Abonent abonent){
        if(abonent!=null&&
                (
                                (abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0)
                                ||
                                (abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0)
                                ||
                                (abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0)
                                ||
                                (abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0)
                                ||
                                (abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0)
                )
                ){
            Criteria criteria = mainsessionFactory.getCurrentSession().createCriteria(Counterr.class);
                    if(abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0){
                        criteria.add(Restrictions.eq("ls",abonent.getCspot()));
                        Counterr cnt = (Counterr)criteria.uniqueResult();
                        if(cnt!=null){
                            return cnt;
                        }
                    }
                            if(abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0){
                                criteria.add(Restrictions.like("fio_customer",abonent.getCspot2()));
                            }if(abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0){
                                criteria.add(Restrictions.like("adress",abonent.getAddress1()));
                            }if(abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0){
                                criteria.add(Restrictions.like("dom",abonent.getAddress2()));
                            }if(abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0){
                                criteria.add(Restrictions.like("raion",abonent.getNregion()));
                            }
                                    List result_search = criteria.list();
                                    if(result_search!=null&&result_search.size()!=0){
                                        return result_search;
                                    }
            Criteria criteria2 = mainsessionFactory.getCurrentSession().createCriteria(Chinameters.class);
                    if(abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0){
                        criteria2.add(Restrictions.eq("cust_code",abonent.getCspot()));
                        Chinameters chch = (Chinameters)criteria2.uniqueResult();
                        if(chch!=null){
                            return chch;
                        }
                    }
                            if(abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0){
                                criteria2.add(Restrictions.like("cust_name",abonent.getCspot2()));
                            }if(abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0){
                                criteria2.add(Restrictions.like("cust_adr1",abonent.getAddress1()));
                            }if(abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0){
                                 criteria2.add(Restrictions.like("cust_adr2",abonent.getAddress2()));
                            }if(abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0){
                                 criteria2.add(Restrictions.like("region",abonent.getNregion()));
                            }
                                    List result_search2 = criteria2.list();
                                    if(result_search2!=null&&result_search2.size()!=0){
                                        return result_search2;
                                    }

        }
        return null;
    }
}
