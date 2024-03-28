package com.ff.sheetsintegration.services;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.sheetsintegration.entity.Chapter;
import com.ff.sheetsintegration.entity.Subject;
import com.ff.sheetsintegration.entity.Topic;
import com.ff.sheetsintegration.repository.ChapterRepository;
import com.ff.sheetsintegration.repository.SubjectRepository;
import com.ff.sheetsintegration.repository.TopicRepository;
import com.ff.sheetsintegration.util.SheetsUtility;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	ChapterRepository chapterRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	SheetsUtility api;

	public void saveTheDataFromSheets() throws IOException, GeneralSecurityException {
		
		List<List<Object>> dataFromSheets = api.getDataFromGoodSheets();
		
		Subject subject = null;
		Chapter chapter = null;
		for(int row=0; row<dataFromSheets.size(); row++) {
			
			List<Object> rowData = dataFromSheets.get(row);
			
			if(rowData.size()==1) {
				
				subject = new Subject();
				subject.setName((String)rowData.get(0));
				Subject save = subjectRepository.save(subject);
				if(save != null) {
					System.err.println("subject saved");
				}
				continue;
				
			}
			
			for(int column = 0; column < rowData.size(); column++) {
				
				Object cellData = rowData.get(column);
				String s = "";
				if(!s.equals((String)cellData) && column==1) {
					
					chapter = new Chapter();
					chapter.setName((String)cellData);
					chapter.setSubject(subject);
					Chapter save = chapterRepository.save(chapter);
					if(save != null) {
						System.err.println("chapter saved!");
					}
					
				}
				else if(!s.equals((String)cellData) && column==2) {
					Topic topic = new Topic();
					topic.setName((String)cellData);
					topic.setChapter(chapter);
					Topic save = topicRepository.save(topic);
					if(save != null) {
						System.err.println("topic saved!");
					}
				}else {
					continue;
				}
				
			}
			
			
			
		}
		
		
		
		
	}
	
	


}
