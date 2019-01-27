package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Entity.BookStrategy;

public interface BookOprationService {
    BookStrategy getBookStrategyById(int id);
}
