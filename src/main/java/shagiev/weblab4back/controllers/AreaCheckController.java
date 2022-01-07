package shagiev.weblab4back.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shagiev.weblab4back.beans.PointBean;
import shagiev.weblab4back.repositories.PointDataRepository;
import shagiev.weblab4back.services.AreaCheckService;
import shagiev.weblab4back.services.PointValidationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AreaCheckController {

    private final PointDataRepository pointDataRepository;
    private final AreaCheckService areaCheckService;
    private final PointValidationService pointValidationService;

    @CrossOrigin
    @GetMapping("/points")
    public ResponseEntity<List<PointBean>> getAllPoints(HttpServletRequest request) {
        return ResponseEntity.ok(pointDataRepository.findAllByUsername("super"));
    }

    @CrossOrigin
    @PostMapping("/points/checkhit")
    public ResponseEntity<PointBean> checkPoint(@RequestBody PointBean point, HttpServletRequest request) {
        if (pointValidationService.isValid(point)) {
            areaCheckService.check(point);
            point.setUsername("super");
            pointDataRepository.save(point);
            return ResponseEntity.ok(point);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
