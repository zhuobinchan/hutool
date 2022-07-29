package cn.hutool.core.date.format.parser;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.DefaultDateBasic;
import cn.hutool.core.text.StrUtil;

/**
 * 时间日期字符串，日期默认为当天，支持格式类似于；
 * <pre>
 *   HH:mm:ss
 *   HH:mm
 * </pre>
 *
 * @author looly
 * @since 6.0.0
 */
public class TimeParser extends DefaultDateBasic implements DateParser {

	public static TimeParser INSTANCE = new TimeParser();

	@Override
	public DateTime parse(String source) {
		source = StrUtil.format("{} {}", DateUtil.formatToday(), source);
		if (1 == StrUtil.count(source, ':')) {
			// 时间格式为 HH:mm
			return new DateTime(source, DatePattern.NORM_DATETIME_MINUTE_PATTERN);
		} else {
			// 时间格式为 HH:mm:ss
			return new DateTime(source, DatePattern.NORM_DATETIME_FORMAT);
		}
	}
}