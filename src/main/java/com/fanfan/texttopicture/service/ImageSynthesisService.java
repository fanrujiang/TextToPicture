package com.fanfan.texttopicture.service;

import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesis;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisParam;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisResult;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImageSynthesisService {


    @Value("${ali.apiKey}")
    private String apiKey;

    public List<String> callImageSynthesis(int n, String size, String prompt, String style) throws ApiException, NoApiKeyException {
        Constants.apiKey = apiKey;
        ImageSynthesis is = new ImageSynthesis();
        ImageSynthesisParam param =
                ImageSynthesisParam.builder()
                        .model(ImageSynthesis.Models.WANX_V1)
                        .n(n)
                        .size(size)
                        .prompt(prompt)
                        .style(style)
                        .build();
        ImageSynthesisResult result = is.call(param);
        List<String> imageUrls = new ArrayList<>();
        List<Map<String, String>> results = result.getOutput().getResults();
        for (Map<String, String> stringStringMap : results) {
            imageUrls.add(stringStringMap.get("url"));
        }



        return imageUrls;
    }
}
