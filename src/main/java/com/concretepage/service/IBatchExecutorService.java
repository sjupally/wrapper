package com.concretepage.service;

import java.io.FileNotFoundException;

/**
 * Created by Srikanth on 5/26/2017.
 */
public interface IBatchExecutorService {
    public void execute(String sqlQuery) throws FileNotFoundException, Exception;
}
