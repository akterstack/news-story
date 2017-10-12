<template>
  <div class="layout-padding card-examples row items-start" style="width: 40%; text-align: left">
    <q-card color="neutral">
      <q-card-main>
        <q-field>
          <q-input type="textarea" v-model="story" float-label="JSON" :value="story" style="min-width:600px" />
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
    this.renderStoryJson()
  },

  methods: {
    renderStoryJson () {
      this.$http.get('/stories/' + this.$route.params.id)
        .then(resp => {
          console.log(resp)
          this.story = JSON.stringify(resp.data, null, 4)
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
