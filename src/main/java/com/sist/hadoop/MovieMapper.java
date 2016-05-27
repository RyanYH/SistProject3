package com.sist.hadoop;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MovieMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] feel = {"사랑","행복", "감동", "순수", "힐링", "애정", "로맨틱",
			"감성", "우울", "절망", "애잔", "아픔", "연민", "비극", 
			"즐거움", "웃음", "유머", "개그", "코미디", "코믹", "일상",
			"스릴", "소름", "긴장", "반전", "호러", "충격", "귀신",
			"할리우드", "대박", "감탄", "연기력", "모험", "범죄", "스펙타클"
	};
	Pattern[] pattern=new Pattern[feel.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		for(int i=0;i<feel.length;i++) {
			pattern[i]=Pattern.compile(feel[i]);
		}
		Matcher[] matcher=new Matcher[feel.length];
		for(int i=0;i<feel.length;i++) {
			matcher[i]=pattern[i].matcher(value.toString());
			while(matcher[i].find()) {
				result.set(feel[i]);
				context.write(result, one);
			}
		}
	}
}
