//package com.jun.junrpc.utils;
//
//import cn.hutool.core.util.StrUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//
//import java.io.InputStream;
//
//public class ConfigLoader {
//
//    /**
//     * 加载配置对象
//     *
//     * @param tClass 目标配置类
//     * @param prefix 配置前缀
//     * @param <T>    泛型类型
//     * @return 配置对象
//     */
//    public static <T> T loadConfig(Class<T> tClass, String prefix) {
//        return loadConfig(tClass, prefix, "");
//    }
//
//    /**
//     * 加载配置对象，支持区分环境
//     *
//     * @param tClass      目标配置类
//     * @param prefix      配置前缀
//     * @param environment 环境标识（如 dev、test、prod）
//     * @param <T>         泛型类型
//     */
//    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
//        // 构建配置文件路径
//        StringBuilder configFileBuilder = new StringBuilder("application");
//        if (StrUtil.isNotBlank(environment)) {
//            configFileBuilder.append("-").append(environment);
//        }
//        configFileBuilder.append(".yaml");
//
//        // 加载 YAML 配置文件
//        String configFilePath = configFileBuilder.toString();
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        try (InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream(configFilePath)) {
//            if (inputStream == null) {
//                throw new RuntimeException("Config file not found: " + configFilePath);
//            }
//
//            // 解析 YAML 文件为 Java Bean
//            return mapper.readValue(inputStream, tClass);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load config", e);
//        }
//    }
//}