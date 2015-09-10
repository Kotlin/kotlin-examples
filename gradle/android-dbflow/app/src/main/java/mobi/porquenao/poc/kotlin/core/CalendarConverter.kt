package mobi.porquenao.poc.kotlin.core

import com.raizlabs.android.dbflow.converter.TypeConverter
import com.raizlabs.android.dbflow.annotation.TypeConverter as TypeConverterAnnotation
import java.util.Calendar

@TypeConverterAnnotation
public class CalendarConverter : TypeConverter<Long, Calendar>() {

    override fun getDBValue(model: Calendar): Long? {
        return model.timeInMillis
    }

    override fun getModelValue(data: Long?): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = data!!
        return calendar
    }

}
