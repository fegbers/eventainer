package de.fegbers.eventainer.utils;

import org.apache.commons.lang3.StringUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DockerUtils
{
    public String cleanImage(String image)
    {
        if (StringUtils.isBlank(image))
        {
            return null;
        }
        if (image.contains("@"))
        {
            return image.substring(0, image.indexOf('@'));
        }
        return image;
    }
}
