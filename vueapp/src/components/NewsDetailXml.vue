<template>
  <div class="layout-padding card-examples row items-start" style="width: 40%; text-align: left">
    <q-card color="neutral">
      <q-card-main>
        <q-field>
          <q-input type="textarea" v-model="story" float-label="XML" :value="story" style="min-width:600px" />
        </q-field>
      </q-card-main>
      <q-card-actions>
        <q-btn flat @click="back()" style="color:black">Back</q-btn>
      </q-card-actions>
    </q-card>
  </div>
</template>

<script>
import {
  QLayout,
  QToolbar,
  QToolbarTitle,
  QCard,
  QCardTitle,
  QCardMain,
  QCardSeparator,
  QCardActions,
  QBtn,
  QField,
  QInput
} from 'quasar'

import formatXml from 'xml-formatter'

export default {
  components: {
    QLayout,
    QToolbar,
    QToolbarTitle,
    QCard,
    QCardTitle,
    QCardMain,
    QCardSeparator,
    QCardActions,
    QBtn,
    QField,
    QInput
  },
  data () {
    return {
      story: {
        author: {}
      }
    }
  },

  created () {
    this.renderStoryXml()
  },

  methods: {
    renderStoryXml () {
      this.$http.get('/stories/' + this.$route.params.id, {headers: {'Accept': 'application/xml'}})
        .then(resp => {
          console.log(resp)
          this.story = formatXml(resp.data)
        })
    },

    back () {
      this.$router.go(-1)
    }
  }
}
</script>

<style>
</style>
