package star.service;

import com.github.pagehelper.PageInfo;
import star.pojo.Adopt;
import star.pojo.AdoptQuery;

public interface AdoptService {
    Adopt addNewAdopt(Adopt adopt);
    PageInfo getAdoptListByParam(AdoptQuery adoptQuery);
}
