package mobi.porquenao.poc.kotlin.core

import com.raizlabs.android.dbflow.sql.language.Select

public object ItemRepository {

    public fun getAll(): MutableList<Item> {
        return Select()
                .from(Item::class.java)
                .where()
                .orderBy(false, Item_Table.UPDATED_AT)
                .queryList()
    }

}
