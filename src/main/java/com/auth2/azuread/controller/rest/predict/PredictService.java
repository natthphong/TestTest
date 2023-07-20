package com.auth2.azuread.controller.rest.predict;

import ai.djl.Application;
import ai.djl.ModelException;
import ai.djl.basicmodelzoo.BasicModelZoo;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@Slf4j
public class PredictService {
    public DetectedObjects predict(MultipartFile file) throws IOException, ModelException, TranslateException {
        InputStream is = file.getInputStream();
        Image img = ImageFactory.getInstance().fromInputStream(is);
        Criteria<Image, DetectedObjects> criteria =
                Criteria.builder()
                        .optApplication(Application.CV.OBJECT_DETECTION)
                        .optModelUrls("https://resources.djl.ai/benchmark/squeezenet_v1.1.tar.gz")
                        .setTypes(Image.class, DetectedObjects.class)
                        .optFilter("backbone", "resnet50")
                        .optProgress(new ProgressBar())
                        .build();
//        Criteria<Image, Classifications> criteria =
//                Criteria.builder()
//                        .optApplication(Application.CV.OBJECT_DETECTION)
//                        .setTypes(Image.class, Classifications.class)
//                        .optFilter("backbone", "resnet50")
//                        .optModelUrls("https://resources.djl.ai/benchmark/squeezenet_v1.1.tar.gz")
//                        .optProgress(new ProgressBar())
//                        .build();
//
//        ZooModel<Image, Classifications> ssd = criteria.loadModel();

        ZooModel<Image, DetectedObjects> model = BasicModelZoo.loadModel(criteria);
//        try (ZooModel<Image, DetectedObjects> model = ModelZoo.loadModel(criteria)) {
//            try (Predictor<Image, DetectedObjects> predictor = model.newPredictor()) {
//                DetectedObjects detection = predictor.predict(img);
//                saveBoundingBoxImage(img, detection);
//                return detection;
//            }
//        }
        return null;
    }

    private void saveBoundingBoxImage(Image img, DetectedObjects detection)
            throws IOException {
        Path outputDir = Paths.get("classpath:/output");
        Files.createDirectories(outputDir);

        // Make image copy with alpha channel because original image was jpg
        Image newImage = img.duplicate();
        newImage.drawBoundingBoxes(detection);

        Path imagePath = outputDir.resolve("detected-objects.png");
        // OpenJDK can't save jpg with alpha channel
        newImage.save(Files.newOutputStream(imagePath), "png");
        log.info("Detected objects image has been saved in: {}", imagePath);
    }
}
