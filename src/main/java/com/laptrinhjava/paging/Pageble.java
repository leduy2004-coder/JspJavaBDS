package com.laptrinhjava.paging;

import com.laptrinhjava.sort.Sorter;

public interface Pageble {
	Integer getPage();

	Integer getOffset();

	Integer getLimit();

	Sorter getSorter();
}
