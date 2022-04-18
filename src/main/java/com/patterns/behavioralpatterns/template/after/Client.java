package com.patterns.behavioralpatterns.template.after;

public class Client {

	public static void main(String[] args) {
		FileProcessor fileProcessor = new Multiply("number.txt");
		int result = fileProcessor.process();
		System.out.println(result);
		
		FileProcessorV2 fileProcessor2 = new FileProcessorV2("number.txt");
		fileProcessor2.process(new Operator() {
			
			@Override
			public int getResult(int result, int number) {
				return result +=number;
			}
		});
		
		
		FileProcessorV2 fileProcessor3 = new FileProcessorV2("number.txt");
		fileProcessor3.process((result1, number) -> result1 += number);
		
		FileProcessorV2 fileProcessor4 = new FileProcessorV2("number.txt");
		fileProcessor3.process(new PlusV2());
		
	}
}
