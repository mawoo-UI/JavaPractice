package study7;

import java.util.concurrent.atomic.AtomicInteger;

public class FileDownloadExample {
	public static void main(String[] args) {
		// 다운로드할 파일 정보
		String[] files = {
                "File1.zip (50MB)",
                "File2.iso (2GB)",
                "File3.txt (1KB)",
                "File4.mp4 (800MB)"
            };
            
            // 파일별 다운로드 스레드 생성
            Thread[] downloaders = new Thread[files.length];
            for (int i = 0; i < files.length; i++) {
                final String file = files[i];
                // 각 파일마다 다른 다운로드 시간 시뮬레이션
                final int downloadTime = (i+1) * 1000; 
                
                downloaders[i] = new Thread(() -> {
                    System.out.println(file + " 다운로드 시작");
                    AtomicInteger progress = new AtomicInteger(0);
                    
                    // 진행률 표시 스레드
                    Thread progressThread = new Thread(() -> {
                        while (progress.get() < 100) {
                            try {
                                Thread.sleep(downloadTime / 10);
                                progress.addAndGet(10);
                                System.out.println(file + " - " + progress.get() + "% 완료");
                            } catch (InterruptedException e) {
                                break;
                            }
                        }
                    });
                    
                    progressThread.start();
                    
                    try {
                        // 다운로드 완료까지 대기
                        Thread.sleep(downloadTime);
                        progressThread.join();
                        System.out.println(file + " 다운로드 완료!");
                    } catch (InterruptedException e) {
                        System.out.println(file + " 다운로드 취소됨");
                        progressThread.interrupt();
                    }
                });
                
                downloaders[i].start();
            }
            
            // 모든 다운로드 완료 대기
            for (Thread downloader : downloaders) {
                try {
                    downloader.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("모든 파일 다운로드 완료!");
        }
    }