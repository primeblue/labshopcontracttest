<template>

    <v-data-table
        :headers="headers"
        :items="getInventory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GetInventoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            getInventory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/getInventories'))

            temp.data._embedded.getInventories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.getInventory = temp.data._embedded.getInventories;
        },
        methods: {
        }
    }
</script>

