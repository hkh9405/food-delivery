<template>

    <v-data-table
        :headers="headers"
        :items="deliveryInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeliveryInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "orderId", value: "orderId" },
                { text: "custId", value: "custId" },
                { text: "custAddr", value: "custAddr" },
                { text: "custTel", value: "custTel" },
                { text: "orderInfo", value: "orderInfo" },
                { text: "totPrice", value: "totPrice" },
                { text: "cmpltTime", value: "cmpltTime" },
            ],
            deliveryInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deliveryInfos'))

            temp.data._embedded.deliveryInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deliveryInfo = temp.data._embedded.deliveryInfos;
        },
        methods: {
        }
    }
</script>

