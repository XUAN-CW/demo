import lombok.Data;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author XUAN
 * @date 2021/3/9 - 14:45
 * @references
 * @purpose
 * @errors
 */
@Data
public class GetImageFromVideo {

    FFmpegFrameGrabber fFmpegFrameGrabber;
    File video;
    File videoDirectory;
    File imageDirectory;

    GetImageFromVideo(File video){
        setfFmpegFrameGrabber(video.getAbsolutePath());
        setVideo(video);
        setVideoDirectory(video.getParentFile());
        setImageDirectory(video.getParentFile().getAbsoluteFile()+File.separator+video.getName()+"-[ImageFromVideo]");
    }

    void getFrameAt(int position) throws Exception {
        //获取视频总帧数
        fFmpegFrameGrabber.start();
        int allFrame = fFmpegFrameGrabber.getLengthInFrames();
        if (position<0 || position > allFrame){
            throw new Exception("超出视频帧总数或输入为负数，视频总帧数为"+allFrame);
        } else {
            Frame frame;//Frame对象
            for (int flag = 0;flag <= allFrame;flag++) {
                frame = fFmpegFrameGrabber.grabImage();
                //对视频的第 position 帧进行处理
                if (frame != null && flag==position) {
                    //文件储存对象
                    Java2DFrameConverter converter = new Java2DFrameConverter();
                    BufferedImage bufferedImage = converter.getBufferedImage(frame);
                    //文件绝对路径+名字
                    int thisFrameInSecond= (int) (flag/fFmpegFrameGrabber.getFrameRate());
                    String imageOutputPath = imageDirectory+File.separator
                            + String.format("[第%0"+String.valueOf(allFrame).length()+"d帧]", flag)
                            + String.format("[%02d-%02d-%02d]", thisFrameInSecond/3600,thisFrameInSecond/60,thisFrameInSecond%60)
                            + ".jpg";
                    ImageIO.write(bufferedImage, "jpg", new File(imageOutputPath));
                    break;
                }
            }
        }
        fFmpegFrameGrabber.stop();
        fFmpegFrameGrabber.close();
    }

    void getFrames(int frameNumber) throws Exception {
        //获取视频总帧数
        fFmpegFrameGrabber.start();
        int allFrame = fFmpegFrameGrabber.getLengthInFrames();
        Frame frame;//Frame对象
        for (int flag = 0;flag <= allFrame;flag++) {
            System.out.println(flag+":"+fFmpegFrameGrabber.getLengthInFrames());
            frame = fFmpegFrameGrabber.grabImage();
            //对视频的第 position 帧进行处理
            if (frame != null && flag%(allFrame/frameNumber) == 0) {
                //文件储存对象
                Java2DFrameConverter converter = new Java2DFrameConverter();
                BufferedImage bufferedImage = converter.getBufferedImage(frame);
                //文件绝对路径+名字
                int thisFrameInSecond= (int) (flag/fFmpegFrameGrabber.getFrameRate());
                String imageOutputPath = imageDirectory+File.separator
                        + String.format("[第%0"+String.valueOf(allFrame).length()+"d帧]", flag)
                        + String.format("[%02d-%02d-%02d]", thisFrameInSecond/3600,thisFrameInSecond/60,thisFrameInSecond%60)
                        + ".jpg";
                ImageIO.write(bufferedImage, "jpg", new File(imageOutputPath));
            }
        }

        fFmpegFrameGrabber.stop();
        fFmpegFrameGrabber.close();
    }

    public void setfFmpegFrameGrabber(String videoPath) {
        FFmpegFrameGrabber fFmpegFrameGrabber = new FFmpegFrameGrabber(videoPath);
        this.fFmpegFrameGrabber = fFmpegFrameGrabber;
    }

    public void setImageDirectory(String imageDirectory) {
        File imageDir = new File(imageDirectory);
        if (!imageDir.exists()){
            imageDir.mkdir();
        }
        this.imageDirectory = imageDir;
    }
}
