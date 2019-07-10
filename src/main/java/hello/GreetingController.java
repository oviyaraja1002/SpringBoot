package hello;


import Model.Patient;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
//
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    private String UPLOAD_DIR = "D:\\file\\sample1.txt";
//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
//    @RequestMapping("/upload")
//    public void uploadFile( @RequestParam("file") MultipartFile file) throws IOException
//    {
//        saveUploadedFiles(file);
//    }
    @GetMapping("/oviya")
    public
    Patient oviya() throws Exception
    {
        Reader rr = new Reader();
        String res[]=rr.dothis(UPLOAD_DIR);
        return new Patient(res[0],res[1],res[2],res[3],res[4]);

    }
//    private void saveUploadedFiles(MultipartFile file) throws IOException
//    {
//      byte[] bytes = file.getBytes();
//      Path path = Paths.get(UPLOAD_DIR+file.getOriginalFilename());
//      Files.write(path,bytes);
//    }
}
