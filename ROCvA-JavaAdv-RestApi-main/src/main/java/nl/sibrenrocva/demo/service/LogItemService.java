package nl.sibrenrocva.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.sibrenrocva.demo.model.LogItem;
import nl.sibrenrocva.demo.repository.LogItemRepository;

@Service
public class LogItemService {

    @Autowired
    private LogItemRepository logItemRepository;

    public void log(String level, String message) {
        LogItem logItem = new LogItem(level, message);
        logItemRepository.save(logItem);
        System.out.println(level + ": " + message);
    }
}
